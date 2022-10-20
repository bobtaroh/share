# Repository for sharing my efforts through my research
## [Classical Shadow](/Classical%20Shadow)
量子力学に従う系の状態は一般に $|\Psi\rangle$ というベクトルで記述できる。  
その状態に対して、密度行列 $\rho=|\Psi\rangle\langle\Psi|$ という量が定義される。　  
この量を用いることで系が持っている量子状態や物理量の期待値などの評価を行うことができる。  
しかし、量子状態 $|\Psi\rangle$ を求めることは極めて困難なことが知られており、厳密に密度行列も得ることは難しい。  
そこで、未知の量子状態に対応した密度行列を推定する手法である*Classical Shadow approximation*[1]という手法が提案されており、Pennylaneという量子コンピューターシュミレーターを用いた実装が行われていた。研究で利用できるかを吟味するために理解を深めることを目的に、その実装をQulacsと呼ばれる大阪大学が開発した量子コンピューターのシュミレーターで行った。  
[1]Hsin-Yuan Huang,Richard Kueng and John Preskill. [Predicting Many Properties of a Quantum System from Very Few Measurements](https://arxiv.org/abs/2002.08953). arXiv:2002.08953v2 [quant-ph] 22 Apr 2020.
## [Shallow Trotter Circuit](/Shallow%20Trotter%20Circuit)
有効な新薬や新材料の開発には物質をミクロな描像で理解することが大切である。  
つまり、量子力学に従うミクロな系がとりうる最もエネルギー低い状態(基底状態)の特性を理解することが、分子や原子レベルの予測をより高速かつ正確に行うことができるようになり、
その特性の中でも、基底エネルギーの値と基底状態を知ることが、系を理解することの大きな手助けになることが知られている。
