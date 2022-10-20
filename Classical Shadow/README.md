# Classical Shadow
量子力学に従う系の状態は一般に $|\Psi\rangle$ というベクトルで記述できる。  
その状態に対して、密度行列 $\rho=|\Psi\rangle\langle\Psi|$ という量が定義される。　  
この量を用いることで系が持っている量子状態や物理量の期待値などの評価を行うことができる。  
しかし、それらを求めるには膨大な計算コストがかかってしまうことから、極めて困難なことが知られている。  
そこで、未知の量子状態に対応した密度行列を推定する手法である*Classical Shadow approximation*[1]という手法が提案されており、Pennylaneという量子コンピューターシュミレーターを用いた実装が行われていた。研究で利用できるかを吟味するために理解を深めることを目的に、その実装をQulacsと呼ばれる大阪大学が開発した量子コンピューターのシュミレーターで行った。  
[1]Hsin-Yuan Huang,Richard Kueng and John Preskill. [Predicting Many Properties of a Quantum System from Very Few Measurements](https://arxiv.org/abs/2002.08953). arXiv:2002.08953v2 [quant-ph] 22 Apr 2020.
