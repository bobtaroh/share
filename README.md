# Repository for sharing my efforts through my research
## [Classical Shadow](/Classical%20Shadow)
量子力学に従う系の状態は一般に $|\Psi\rangle$ というベクトルで記述できる。  
その状態に対して、密度行列 $\rho=|\Psi\rangle\langle\Psi|$ という量が定義される。　  
この量を用いることで系が持っている量子状態や物理量の期待値などの評価を行うことができる。  
しかし、量子状態 $|\Psi\rangle$ を求めることは極めて困難なことが知られており、厳密に密度行列も得ることは難しい。  
そこで、未知の量子状態に対応した密度行列を推定する手法である*Classical Shadow approximation*[1]という手法が提案されており、Pennylaneという量子コンピューターシュミレーターを用いた実装が行われていた。研究で利用できるかを吟味するために理解を深めることを目的に、その実装をQulacsと呼ばれる大阪大学が開発した量子コンピューターのシュミレーターで行った。  
[1]Hsin-Yuan Huang,Richard Kueng and John Preskill. [Predicting Many Properties of a Quantum System from Very Few Measurements](https://arxiv.org/abs/2002.08953). arXiv:2002.08953v2 [quant-ph] 22 Apr 2020.
## [Shallow Trotter Circuit](/Shallow%20Trotter%20Circuit)
現代社会の発展にはさまざまな進化が相互作用して促進されている。
その一つに含まれる科学の発展の中でも、有効な新薬や新材料などの開発が挙げられる。
それら開発過程では、物質を量子力学に従うミクロな描像でモデルを構築したり、シミュレートしたりすることでミクロな系がとりうる最もエネルギー低い状態(基底状態)の特性を理解することが必要となるが、多大な計算コストがかかってしまうことから、現実的に必要な大きな系で計算することが困難な状況にある。  
そこで、その計算を量子コンピューターを用いることで高速かつ正確に行うことができる*Shallw Trotter Circuit*[2]と呼ばれる手法が提案されている。私はその技術を応用するために、理解を深めることを目的に、その実装をQulacsと呼ばれる大阪大学が開発した量子コンピューターのシュミレーターで行った。  
[2]Mingxia Huo and Ying Li. [Error-resilient Monte Carlo quantum simulation of imaginary time](https://arxiv.org/abs/2109.07807). arXiv:2109.07807v2 [quant-ph] 15 Sep 2022
