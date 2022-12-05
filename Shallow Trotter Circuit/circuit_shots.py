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

import circuit_shots as cs

"""
     Tools to prepare Circuit.
     ・trotter_Ising_circuit_drawer(t,δ,λ,nqubits,circuit) # Add Trotterised RTS operator to quantum circuit.
     ・observable_circuit_drawer(δ,λ,nqubits,circuit,sampled_Obs) # Add controlled selected observable Oi to quantum circuit.
     ・
"""

# Add Trotterised RTS operator to quantum circuit.
def trotter_Ising_circuit_drawer(t,δ,λ,nqubits,circuit):
    M = int(t/δ)
    Vt_i_gate = Identity(0)
    for i in range(M):
        for i in range(nqubits-1):
            Vt_i_gate = merge(Vt_i_gate,CNOT(i,(i+1)%(nqubits-1)))
            Vt_i_gate = merge(Vt_i_gate,RZ((i+1)%(nqubits-1),-2*(2-λ)*δ)) # exp(i*α*δ*Z)=RZ(2*α*δ) => in qulacs => RZ(-2*α*δ)
            Vt_i_gate = merge(Vt_i_gate,CNOT(i,(i+1)%(nqubits-1)))
        for i in range(nqubits-1):
            Vt_i_gate = merge(Vt_i_gate,RX(i%(nqubits-1),-2*λ*δ))  # exp(i*β*δ*X)=RX(2*β*δ) => in qulacs => RX(-2*β*δ)
    Vt_i_mat_gate = to_matrix_gate(Vt_i_gate)
    control_index = nqubits-1
    control_with_value = 1
    Vt_i_mat_gate.add_control_qubit(control_index,control_with_value)
    circuit.add_gate(Vt_i_mat_gate)
    

# Add controlled selected observable Oi to quantum circuit.
def observable_circuit_drawer(δ,λ,nqubits,circuit,sampled_Obs):
    index = int(sampled_Obs[1])
    gate = int(sampled_Obs[0])
    Obs_gate = Identity(index)
    if gate == 3:
        Obs_gate = merge(Obs_gate,Z(index))
        Obs_gate = merge(Obs_gate,Z((index+1)%(nqubits-1)))
        Obs_mat_gate = to_matrix_gate(Obs_gate)
    else:
        Obs_gate = merge(Obs_gate,X(index))
        Obs_mat_gate = to_matrix_gate(Obs_gate)
    control_index = nqubits-1
    control_with_value = 1
    Obs_mat_gate.add_control_qubit(control_index,control_with_value)
    circuit.add_gate(Obs_mat_gate)
    