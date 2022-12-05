import matplotlib.pyplot as plt
import numpy as np
import time
import datetime as dt
import random
import math
import scipy.optimize
from scipy import stats
from scipy.integrate import quad
from qulacs import QuantumState, Observable, QuantumCircuit
from qulacsvis import circuit_drawer
from qulacs.circuit import QuantumCircuitOptimizer
from qulacs.state import inner_product
from qulacs.gate import Identity, X,Y,Z
from qulacs.gate import H,S,Sdag,T,Tdag,sqrtX,sqrtXdag,sqrtY,sqrtYdag
from qulacs.gate import RX,RY,RZ,CNOT, CZ, SWAP
from qulacs.gate import to_matrix_gate,RandomUnitary,DenseMatrix,merge

import generator as gen

"""
    Tools to sample t from the pdf g(t).
        ・g(t, β, τ) # target pdf g(t)
        ・sampling(tmin=-0.5, tmax=0.5, β=1, τ=10) # rejection sampling
        ・integral_C(f, β, τ, flag=0) # calculate integration of g(t) from (-∞,+∞)
"""
# target pdf g(t)
def g(t, β, τ):
    return 1/np.pi*β/(β**2+t**2)*np.exp(-(β**2+t**2)/2*τ**2)

# rejection sampling
def sampling(tmin=-0.5, tmax=0.5, β=1, τ=10):
    import generator as gen
    
    # maximum value of g(t)
    k = gen.g(0,β,τ)
    while True:
        # sample from the proposed distribution [min_range,max_range)
        t = np.random.uniform(tmin,tmax)
        # sample u from [0,k)
        u = k*np.random.uniform(0,1.0)
        # judge if accept
        if gen.g(t,β,τ) > u:
            return t

# calculate integration of g(t) from (-∞,+∞)
def integral_C(f, β, τ, flag=0):
    I, error = quad(g, -np.inf, np.inf, args=(β, τ))
    if flag == 1:
        return I, error
    else:
        return I
    

"""
    Select observable Oi from O = ΣaiOi by sampling according to its distribution |aj|/aO.
        ・calculate_aO(nqubits, coef_1, coef_2) # calculate total coeficient aO
        ・prepare_sample_target(nqubits, coef_1, coef_2, coef_total) # prepare obs_list_total [[3, 1, coef_1], ..., [1, 1, coef_2]] and prob_list_total [coef_1/aO, ..., coef_2/aO]
        ・select_obs_Ising(nqubits, coef_1, coef_2) # sample one observable list [gate,index,coefficient] according to the distribution of its coeficients
"""
# calculate total coeficient aO
def calculate_aO(nqubits, coef_1, coef_2):
    return (nqubits-1)*abs(coef_1+coef_2)

# prepare obs_list_total [[3, 1, coef_1], ..., [1, 1, coef_2]] and prob_list_total [coef_1/aO, ..., coef_2/aO]
# \bar{H} => the transverse-field Ising model
def prepare_sample_target(nqubits, coef_1, coef_2, aO):
    obs_list_total = [0 for i in range((nqubits-1)*2)]
    prob_list_total = [0 for i in range((nqubits-1)*2)]
    selection_list = [i for i in range((nqubits-1)*2)]
    for i in range((nqubits-1)):
        obs_list_total[i] = [3,i,coef_1]
        obs_list_total[i+(nqubits-1)] = [1,i,coef_2]
        prob_list_total[i] = abs(coef_1)/aO
        prob_list_total[i+(nqubits-1)] = abs(coef_2)/aO
    return obs_list_total, prob_list_total

# numpy version of function preprepare_sample_target 
def prepare_sample_target_numpy(nqubits, coef_1, coef_2, aO):###############Refactoring ## list => numpy.array
    obs_list_total = np.zeros((nqubits-1)*2, dtype='O')
    prob_list_total = np.zeros((nqubits-1)*2, dtype='O')
    selection_list = np.zeros((nqubits-1)*2, dtype='O')
    for i in range((nqubits-1)):
        np.put(obs_list_total, [i, i+(nqubits-1)], [[3,i,coef_1], [1,i,coef_2]])
        np.put(prob_list_total, [i, i+(nqubits-1)], [abs(coef_1)/aO, abs(coef_2)/aO])
    return obs_list_total, prob_list_total

# sample one observable list [gate,index,coefficient] according to the distribution of its coeficients
def select_obs_Ising(nqubits, coef_1, coef_2, aO, obs_list_total, prob_list_total): 
    rng = np.random.default_rng()
    sampled_obs_list = rng.choice(obs_list_total, p=prob_list_total)
    return sampled_obs_list
