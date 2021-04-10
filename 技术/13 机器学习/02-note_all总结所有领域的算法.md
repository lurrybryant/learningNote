[TOC]
Scikit-Learn与TensorFlow机器学习实用指南
机器学习 作者: Sergios Theodoridis
概率视角

# 一. 算法总结
----------------------------------------------
## 1. 模型

(A) 监督学习

- 线性模型：
    线性回归，最小二乘，最小角回归LARS，拉索，岭，弹性网
    逐步向前，局部加权，多元自适应回归样条
    保序
    非线形回归，广义线性模型（对数线性回归），多项式回归
    huber回归
    非参数回归
    逻辑回归（LR，softmax），最大熵模型MEM(MaximumEntropy Model)
    感知机（Perception）
    支持向量机（SVM，SVR，多类SVM，nu）
    判别分析（LDA，QDA），FLD，菲舍尔判别分析FDA，lmse，SGDClassifier
    非线形判别分析，分段线形判别分析，
    势函数法
    Orthogonal Matching Pursuit model (OMP)
    Passive Aggressive
    RANSAC (RANdom SAmple Consensus) 
    Theil-Sen Estimator
    Adaline 算法
- 交叉分解：
    偏最小二乘法（PLS）
    典型相关分析（CCA）
- 近邻模型：
    k近邻（kNN）
    基于案例推理
- 贝叶斯模型：
    朴素贝叶斯（NB），伯努利、高斯、多项式
    半朴素贝叶斯
    贝叶斯信念网络，动态信念网络
    平均单依赖估计（Averaged One-Dependence Estimators， AODE，平均-依赖性估计AODE）
    贝叶斯网络
    贝叶斯ARD回归，贝叶斯岭回归
    贝叶斯学习
- 树模型：
    ID3，C4.5，CART，
    Decision Stump，
    SLIQ，
    Chi-squared Automatic Interaction Detection(CHAID)，
    C5.0，
- 集成学习模型：
    boosting（提升树，GBDT，XGBoost，Adaboost，catboost，lightGBM），
    bagging（RF，ET，隔离森林IsolationForest，
        完全随机树嵌入，投票，
        Mondrian Forests:Bernoulli Random Forests
        TensorForest:ggRandomForests:
        ParallelForest:gcforest）
    stacking，
    blending
- 多标记学习：
- 多分类学习：
    ovo（n(n-1)个分类器）one vs one
    ovr（n个分类器）     one vs rest
    mvm（ECOC，DAG）
- 概率图模型：
    贝叶斯网，
    隐马尔可夫模型HMM，
    MC(Markov Chain 马尔科夫链)，
    马尔可夫随机场，
    层次化马尔科夫模型，
    马尔科夫网络，
    MEMM(Maximum Entropy Markov Model 最大熵马尔科夫模型)，
    马尔可夫决策过程MDP，
    不完全可观察马尔科夫决策过程POMDP，
    条件随机场，CRF++，
    话题隐狄利克雷模型LDA，层次化狄利克雷模型，
    无限隐特征模型，
    信念传播精确推断，
    近似推断，
    建模和变分推断，
    MCMC，
    Gibbs Random Field
    Gaussian Random Field，
    Google Page Ranking模型，
    Viterbi算法，
    Baum-Welch算法
- 核方法：
    RBF核，核近似，
    KLDA，KCCA，KPCA，K-Fisher
    Kk-means，
    核高斯过程，
    核岭回归，
    核化密度估计，
- 其它：
    EM算法，
    变分贝叶斯，
    高斯过程，
    本地散点平滑估计（Locally Estimated Scatterplot Smoothing），
    TextonForest，
    随机映射（高斯，稀疏）
    RBF网络， 
    矩阵提取，
    GLMNet
    VW, 
    Sofia-ML, 
    RGF，
    贝叶斯机器学习

(B) 无监督学习

- 聚类算法：
   - 基于划分（
       k-means，k-means++，k-modes，FK-Means，k-medoids，
       学习向量量化（LVQ），
       高斯混合模型（GMM），
       贝叶斯高斯混合模型， 
       K-Pototypes，CLARANS）
   - 基于密度（DBSCAN）
       局部密度聚类，
       OPTICS，
       DENCLUE，
       CURE
   - 基于层次（AGNES），
       概念聚类，
       単连锁聚类，
       BIRCH，
       DIANA，
       WARD聚类，
       ROCK
   - 基于网格（STING），
       CLIQUE(基于密度和基于网格)，
       WaveCluster
   - 基于模型（EM），
       SOM，
       CobWeb，
   - 图(网络)聚类
   - 高维数据聚类（双聚类，谱聚类），
       FC，
       SVD聚类，
       K-medians，
       mean-shift，
       Canopy，
       AP算法，
       Agglomerative，
       聚类集成
   - 具有约束的聚类     
- 降维算法：
    主成分分析（PCA），
    奇异值分解（SVD，SVD++），
    多维缩放（MDS），
    核化线性降维，
    流形学习（谱嵌入，等度量映射Isomap，局部线性嵌入（LLE）拉普拉斯特征映射LE，局部切空间对齐LTSA，基于LE的局部保持投影LPP），
    t-分布邻域嵌入算法（t-SNE），
    Sammon映射，
    投影追踪（Projection Pursuit），
    因子分析FA，
    PCR，
    独立成分分析ICA，
    非负矩阵分解NNMF，
    度量学习，
    字典学习（稀疏编码，分组稀疏编码），
    压缩感知（稀疏学习），
    隐语义分析LSA，概率隐语义分析PLSA，
- 频繁项集和关联规则提取：
    priori，
    FP-growth，
    Eclat算法
- 异常点检测：
    OneClassSVM，
    局部异常因子Local Outlier Factor (LOF)，
    基于高斯分布，
    基于隔离性

- 密度估计：
    非参数密度估计
- 协方差估计：
    经验，
    收敛、
    稀疏逆、
    robust最小协方差决定.

(C) 深度学习

- 多层前馈神经网络MLP：
    Hopfield网络，
    自组织映射（Self-Organizing Map, SOM），
    深度玻尔兹曼机DBM，
    受限波尔兹曼机（Restricted Boltzmann Machine， RBN），
    伯努利限制玻尔兹曼机，
    Deep Belief Networks（DBN），
    深度神经网络DNN，
    分层时间记忆HTM，
    极端学习机ELM，
    逻辑学习机LLM，
    尖峰神经网络，
    RBFN，RBF网络，
    ART网络，
    级联相关网络，
    Elman网络，
    Random Neural Networks
    概率神经网络PNN
    对向传播神经网络（CPN）
    贝叶斯神经网络
- 卷积神经网络CNN：
    LeNet-5 架构（1998 年），
    ILSVRC 挑战赛的三名获胜者 AlexNet（2012），ZFNet(2013)，
    Overfeat
    NiN，
    GoogLeNet（2014）
    ResNet（2015），
    VGGnet，
    Inception-v4，Xception，Bottleneck layer
    Inception V2
    Inception V3
    Inception-Resnet-V3， 
    WRN （Wide Residual Network）2016
    SqueezeNet
    preResNet，ResNeXt，
    DenseNet， 
    MobileNet， 
    ShuffleNet-V2，
    ENet，
    FractalNet，
    SENet，
- 循环神经网络RNN：
    长短期记忆LSTM，
    Bi-RNN，
    Pervasive Attention，
    CNN4Text，
    textCNN，
    embedding，
    char-rnn，
    ctc，
    Glove embedding，
    ULMFiT，
    BERT，crnn，LSM，GRU
    transformer
    动态驱动递归网络
    动态系统状态估计的贝叶斯滤波
- 生成对抗网络GAN：
    WGAN：抓住低维的幽灵，
    DCGAN：当GANs 遇上卷积，
    ALI：包揽推断业务，
    IRGAN：生成离散样本，
    SeqGAN：
- 自动编码器：
    堆栈式自动编码器（Stacked Auto-encoders），
    稀疏自编码器，
    Denoising Auto-encoders去噪自动编码器，
    Contractive Auto-encoders 收缩自动编码器，
    Seq2Seq，
    变分自动编码器
- 其它：
    FollowNet，
    HyperNet
- 表示学习：
    图神经网络GNN
(D) 其它算法

- 迁移学习：传递式迁移学习TTL
- 主动学习：适合数据丰富但标签号稀缺的情形。
- 终身学习：
- 元学习：
- 竞争学习：
- 概念学习
- 计算学习：VC维度，
- 半监督学习：
    自训练算法，
    图论法，
    半监督SVM，
    多视角算法，
    联合训练，
    低密度分类，
    生成模型，
- 多任务学习：
    SRCNN， 
    DRCN，
- Probabilistic Programming
- 矩阵计算：
- 规则学习：
- 强化学习：
    有模型学习，
    免模型学习，
    SARSA，
    TD，
    MDP，
    Q-learning，
    Deep Reinforcement Learning(Policy Network、Value Network），
    学习自主LA，
    A3C，
    DQN，
    序贯决策，
    决策过程 
    探索与利用 
    深度强化学习
- 模型校准：
- 时间序列分析：
    自回归模型、
    滑动平均模型，
    arma，
    arima.

- 自然语言处理：
    VSM(Vector Space Model向量空间模型)，
    Word2Vec(词向量学习模型)，
    TF(Term Frequency词频)，
    TF-IDF(Term Frequency-Inverse DocumentFrequency 词频-逆向文档频率)，
    MI(MutualInformation 互信息)，
    ECE(Expected Cross Entropy 期望交叉熵)，
    QEMI(二次信息熵)，
    IG(InformationGain 信息增益)，
    IGR(Information Gain Ratio 信息增益率)，
    Gini(基尼系数)，
    x2 Statistic(x2统计量)，
    TEW(TextEvidence Weight文本证据权)，
    OR(Odds Ratio 优势率)，
    N-Gram Model，
    AprioriAll，
    Spade，
    GRU
    nasnet，
    TextRank，
    fastText
    Inference Network Model
    SyntaxNet
    - 智能写作，机器翻译，文本审核，词法分析，依存句法分析，文本纠错，对话情绪识别，新闻摘要，词向量表示，DNN语言模型，情感倾向分析，文章标签，词义相似度，短文本相似度，评论观点抽取，文章分类


- 推荐系统：
    FM，FFM，
    gbdt + lr
    DeepCross
    pid 
    dssm 
    als 
    组合优化 
    dqn 
    POLY2 
    GBDT-LR 
    FTRL 
    LS-PLM
    CCPM
    FNN
    PNN
    WDL
    DeepFM
    DeepGBM
    MLR
    NFM
    AFM
    DCN
    DIN
    DIEN
    MIMN 
    ESMM
    DSIN
    xDeepFM
    AutoInt
    NFFM
    FGCNN
    FiBiNET
    
    LearningToRank
        pointwise常用算法:
            Classification
                Discriminative model for IR (SIGIR 2004)
                McRank (NIPS 2007)
            Regression
                Least Square Retrieval Function (TOIS 1989)
                Regression Tree for Ordinal Class Prediction (Fundamenta Informaticae, 2000)
                Subset Ranking using Regression (COLT 2006)
            Ordinal Classification
                Pranking (NIPS 2002)
                OAP-BPM (EMCL 2003)
                Ranking with Large Margin Principles (NIPS 2002)
                Constraint Ordinal Regression (ICML 2005)
        Pairwise常用算法:
            Learning to Retrieve Information (SCC 1995)
            Learning to Order Things (NIPS 1998)
            Ranking SVM (ICANN 1999)
            RankBoost (JMLR 2003)
            LDM (SIGIR 2005)
            RankNet (ICML 2005)
            Frank (SIGIR 2007)
            MHR(SIGIR 2007)
            GBRank (SIGIR 2007)
            QBRank (NIPS 2007)
            MPRank (ICML 2007)
            IRSVM (SIGIR 2006)
            LambdaRank (NIPS 2006)
            LambdaMART (inf.retr 2010)
        Listwise常用算法:
            Measure-specific
            AdaRank (SIGIR 2007)
            SVM-MAP (SIGIR 2007)
            SoftRank (LR4IR 2007)
            RankGP (LR4IR 2007)
            LambdaMART (inf.retr 2010)（也可以做Listwise）
            Non-measure specific
            ListNet (ICML 2007)
            ListMLE (ICML 2008)
            BoltzRank (ICML 2009)

       
    基于模型，
    DBR(Demographic-based Recommendation 基于人口统计学的推荐)，
      矩阵分解，
      CBR(Context-basedRecommendation 基于内容的推荐)，
      CF(Collaborative Filtering协同过滤)，
      UCF(User-basedCollaborative Filtering Recommendation 基于用户的协同过滤推荐)，
      ICF(Item-basedCollaborative Filtering Recommendation 基于项目的协同过滤推荐)
    Similarity Measure&Distance Measure(相似性与距离度量)：
    Euclidean Distance(欧式距离)，
    ManhattanDistance(曼哈顿距离)，
    Chebyshev Distance(切比雪夫距离)，
    MinkowskiDistance(闵可夫斯基距离)，
    Standardized Euclidean Distance(标准化欧氏距离)，
    MahalanobisDistance(马氏距离)，
    Cos(Cosine 余弦)，
    HammingDistance/Edit Distance(汉明距离/编辑距离)，
    JaccardDistance(杰卡德距离)，
    Correlation Coefficient Distance(相关系数距离)，
    InformationEntropy(信息熵)，
    KL(Kullback-Leibler Divergence）

- 计算机视觉：
    HOG特征&LBP特征&Haar特征，Gabor滤波
    - 目标检测：
        two stage: 
            rcnn，SPP-Net，fast-rcnn，faster-rcnn， 
            更好的特征网络：ms-cnn，hyperNet，PVANet，Light-Head R-CNN，
            更精准的RPN网络：MR-CNN，FPN，CRAFT，
            更完善的ROI分类：R-FCN，CoupleNet，Mask R-CNN, Cascade R-CNN，
            样本后处理：CHEM，Soft-NMS，A-Fast-RCNN, Softer-NMS，
            更大的mini-Batch：MegDet
  
        one stage:
            OverFeat, 
            RetinaNet，
            YOLO，YOLO9000,YOLOhasst，YOLOv2，YOLOv3，
            G-CNN
            SSD R-SSD DSSD DSOD FSSD ESSD，MDSSD，Fire SSD，SSOD，
            RON
  
        CornerNet，  
        Meta Learning， 
        YOLT，
        SNIPER，
        Pelee，
        DetNet，
        M2Det，
        ican，  
        Multi-Fiber Networks，
        SegNet，  
        U-Net，  
        DeepLab (v1 & v2)，   
        PSPNet，  
        Large Kernel Matters，  
        DeepLab v3，  
        instance segmentation，  
        MaskX，  
        RFBNet，  
        胶囊网络，
        3D Object Detection，
        ZSD（Zero-Shot Object Detection），
        OSD（One-Shot object Detection），
        Weakly Supervised Object Detection，
        DQN，
        非最大抑制(non-max suppression, NMS)，  
        在线困难样例挖掘(online hard example mining, OHEM)，  
        在对数空间回归，  
        反最大汇合(max-unpooling)

    - 风格迁移：
        Deformable Part Models DPM， 
        ACF，
        R-CNN，
        CompACT，
        transformnet， 
        PS-GAN
    - 图像分割
        darknet
    - 语义分割
    - 实例分割
    - 图像定位
    - OCR，图像识别，车辆分析，图像审核，图像搜索，人脸识别，人体分析，

- 知识图谱：

- 语音：
    - 语音识别
        CD-DNN-HMM
        TDNN
        CTC
        EESEN
        Deep Speech
        Chain

- 信息检索：pagerank

(E) 优化算法：

- adamW，Cocob优化，
- 常见的几种最优化方法（梯度下降法、牛顿法、拟牛顿法、共轭梯度法等）
- 遗传算法 随机搜寻 爬山算法 Nelder-Mead 算法
































## 2. 建模工具

- 数据处理及可视化：numpy/pandas/scipy/matplotlib/seaborn
- 机器学习：scikit-learn/statsmodel/xgboost/lightGBM/imblearn/mlxtend
- 深度学习：keras/TensorFlow/tflearn/caffe/Theano/Pylearn2/deeplearning4j/Mxnet/CNTK/torch/paddlepaddle
- 自然语言处理: nltk/jieba/
- 交互式环境：ipython notebook
- Java系列：WEKA Machine Learning Workbench 相当于java中的scikit-learn；
- 其他的工具如Massive Online Analysis（MOA）、MEKA 、 Mallet 等也非常有名。更多详细的应用请参考这篇文章《25个Java机器学习工具&库》
- C++系列：mlpack，高效同时可扩充性非常好的机器学习库。
- Shark：文档齐全的老牌C++机器学习库大数据相关
- Hadoop：基本上是工业界的标配了。一般用来做特征清洗、特征处理的相关工作。
- spark：提供了MLlib这样的大数据机器学习平台，实现了很多常用算法。但可靠性、稳定性上有待提高。
- 计算机视觉: Scikit-Image/SimpleCV/openCV／OpenFace／AdaNet／PCV／face_recognition／albumentations／PyTorchCV／imutils／pytessarct／Detectron 
- 其它：[python](https://github.com/josephmisiti/awesome-machine-learning#python-cv)


## 3. [数学统计](http://vdisk.weibo.com/s/yTkCz-lSt3Y8x)

(A) 分析
 
- 数分：
  - <font color="#dd0000">郇中丹 《简明数学分析》</font>
  - 徐森林 stein分析学 北大教程 
  - 柯朗的《微积分和数学分析引论》
  - 胡适耕《数学分析原理与方法》
  - zorich 数学分析
- 实分析/复分析/泛函分析：
  - folland stein实分析 
  - 夏道行的第二册泛函分析 
  - bigrudin 陶哲轩实分析 
  - Royden《实分析》
- 测度论：
  - bogachev测度论
- 常微分方程/偏微分方程：
- 小波分析：
- 变分理论：
- 随机分析/随机微分方程：
- 函数论/算子理论：
- 积分变换：

(B) 代数

- 高代/近世代数/抽象代数/矩阵论/同调代数/表示论： 
  - 范德瓦尔登的《代数学》 丘维声 北大教程  
  - Axler《线性代数应该这样学》
  - Hungerford《algebra》
- 李群：
- 数论：

(C) 几何

- 解析几何/微分几何/整体微分几何/拓扑学(点集拓扑和代数拓扑)/流形：
  - 白正国《黎曼几何》
  - 陈省身和陈维桓合著的《微分几何讲义》
  - 基础拓扑学  
  - Bredon《Topoloy and Geometry》
- 微分几何与广义相对论：

(D) 统计

- 概率论：
  - 钟开莱，王梓坤《概率论基础及其应用》
  - 《Probability and Statistics (4th Edition) by Morris H. DeGroot》
- 统计学基础：
  - 《Think Stats》
  - 《All of Statistics - A Concise Course in Statistical Inference_Larry Wasserman》
  - 《线性统计模型 线性回归与方差分析》
  - 《Introduction to Probability》
- 多元统计：
- 数理统计：
- 回归分析：
- 非参数统计：
- 抽样论：
- 贝叶斯统计：
- 随机过程：
- 时间序列分析：
- 信息论：

(AB) 分析代数

- 人工智能优化算法：
- 数值计算分析：
  - 《Numerical Optimization》
  - 《Numerical Analysis by Richard L. Burden and J. Douglas Faires 8th edition》
  - 《Introduction to Linear Algebra, 4th edition--Gilbert Strang 清晰扫描版》
  - 《Allaire G - Numerical Linear Algebra》
- 运筹学：
- 最优控制：
- 凸优化：
  - 《凸优化_Boyd&Vandenberghe_中文完整版》
  - [Convex Optimization: Algorithms and Complexity](https://arxiv.org/abs/1405.4980)
- 线性系统与复杂系统理论：

(BC) 代数几何

(E) 其它

- 模糊数学：
- 集合论：
- 数学建模：
- 图论：
- 组合数学：
- 逻辑学/数理逻辑：
- 密码学：


## 4. 计算机科学：
(A) 基础学科

- 数据结构：
- 算法设计与分析：
- 算法导论：
  - 《算法导论》
- 操作系统：
  - <font color="#dd0000">《计算机操作系统（第4版）汤小丹、汤子瀛》</font>
- 数据库原理：
- 软件工程：
- 并行计算：
  - 《大规模并行处理器编程实战》David B. Kirk
- 分布式系统：
- 计算机网络：
- 数字图象处理：
- 大数据分析：
- other: （数字逻辑／汇编语言／通信原理／计算机体系结构／编译原理／计算机组成原理／计算机图形学 /可计算理论／嵌入式系统／形式语言与自动机／微机信息与接口／
信息安全／软件体系结构／数据库系统设计／数字语音信号处理／信号与系统／中文信息处理 ／
机器人学／多媒体技术／TCP IP组网基础及应用／网络实验／EDA设计与实践／嵌入式系统／电子商务概论／计算机组织与科学计算／网络存储／虚拟现实／
信息检索导论／游戏开发）
- 代码设计：
  - 《重构-改善既有代码的设计》
  - 《设计模式》

(B) 实践

- python：
  - 《编写高质量代码-改善Python程序的91个建议》
  - 《python 核心编程》第2版和第3版
  - 《利用Python进行数据分析》
  - 《python科学计算第二版》
- sql:
- linux shell: 
  - 《鸟哥的liunx私房菜-基础篇》
  - 《linux shell  编程从初学到精通》 华清远见嵌入式培训中心
  - 《linux shell  编程从入门到精通》张昊
- c++:

(C) 人工智能

- 数据挖掘\模式学习\统计学习\机器学习：
  - <font color="#dd0000">《机器学习》，周志华，机器学习方法理论
  - 《统计学习方法》，李航，统计学习理论性强
  - 《数据挖掘 概念与技术》，Jiawei Han etc.，介绍数据挖掘基础理论
  - [机器学习（含笔记）， Ng](https://github.com/fengdu78/Coursera-ML-AndrewNg-Notes)
  - 《机器学习要领》，ng，机器学习使用指南
  - 《机器学习》，万门大学
  - 《Python数据挖掘入门与实践》，Robert Layton，用sklearn库</font>
  - 《The Elements of Statistical Learning 》， Trevor Hastie etc.，统计学习方法理论
  - 《Pattern Recognition and Machine Learning》
  - 《Machine Learning: A Probabilistic Perspective》
  - 《Introduction to machine learning 2nd edition》
  - 《The Art and Science of Algorithms that Make Sense of Data》
  - 《统计学习基础(数据挖掘、推理与预测)》
  - 《Understanding Machine Learning:From Theory to Algorithms》
  - 《Learning from Data》
  - 《An Introduction to Statistical Learning》
  - 《Machine Learning》
  - 《Artificial Intelligence: A Modern Approach》
  - 《Machine Learning: An Algorithmic Perspective》
  - 机器学习基石， NTU
  - 机器学习技法，NTU
  - 《机器学习实战》，Peter，机器学习代码（未用到sklearn库）
  - 《集体智慧编程》
  - 《机器学习：实用案例解析（中文版，带完整书签）》陈开江
  - 《Data Science from Scratch》
  - 《Data Science for Business》
  - 《Agile Data Science》
- 深度学习：
  - <font color="#dd0000">《Deep learning》， Yoshua Bengio&Ian Goodfellow ，深度学习原理
  - 深度学习（含笔记）， Ng，
  - 《Tensorflow实战谷歌深度学习框架》
  - 《21个项目玩转深度学习：基于TensorFlow的实践详解》
  - 《Hands-On Machine Learning with Scikit-Learn and TensorFlow》
  - 《百面机器学习》</font>
  - 《深度学习基础教程》，ng，深度学习原理
  - 《深度学习ppt》
  - 《Neural networks and Deep Learning》
  - 《动手深度学习》
  - 《Deep Learning with Python 》
  - 《TensorFlow Deep Learning Cookbook》
  - 《TensorFlow机器学习项目实战》 姚鹏鹏译
  - 《TensorFlow实战》黄文坚 唐源
  - 《TensorFlow+For+Machine+Intelligence》
  - 《Deep Learning for Computer Vision with Python》
- 计算机视觉：
  - 《图像处理、分析与机器视觉（第三版）》
- 自然语言处理：
- 推荐系统：
  - 《推荐系统实战》
- 强化学习：
  - 《强化学习原理及其应用》
- 计算广告：
  - 《计算广告》 
- 金融风控：
  - 金融信贷风控中的机器学习
- 计算科学可视化：
- 科普：
  - 《数学之美》
  - 《浪潮之巅》
  - 《大数据》
  - 《物联网》

## 5. 会议期刊
AAAI， CVPR，COLT，ECCV， ICLR，ICCV， ICML，IJCAI，KDD，ICDM，NeurIPS，NIPS，

## 6. 网络

博客园 CSDN 知乎 公众号 微博 博客 简书 搜狐科技 官方文档 github ：

- [公众号](https://mp.weixin.qq.com/s/knphqoCrzCF806fKdX0p6Q)
- [博客](https://www.cnblogs.com/charlotte77/)
- [Github](https://github.com/tensorflow/models/tree/master/research/slim)
  - [资料list](https://github.com/JustFollowUs/Machine-Learning)
- [官网](http://deeplearning.net/2016/07/)
  - scikit-learn，官方文档，机器学习方法算法demo

## 7. 论文
- GPCA: Generalized Principal Component Analysis
- XGBoost: A Scalable Tree Boosting System， Tianqi Chen

- FastXML: A fast, accurate and stable tree-classifier for extreme multi-label learning

- LeNet-5：Gradient-Based Learning Applied to Document Recognition
- GPU-NET：Deep Big Simple Neural Nets Excel on Hand- written Digit Recognition
- AlexNet：ImageNet Classification with Deep Convolutional Neural Networks
- OverFeat: Integrated Recognition, Localization and Detection using Convolutional Networks
- VGG：Very Deep Convolutional Networks for Large-Scale Image Recognition
- NiN：Network In Network
- GoogleNet与Inception：Going Deeper with Convolutions，An Analysis of Deep Neural Network Models for Practical Applications
- Inception-v2：Batch Normalization: Accelerating Deep Network Training by Reducing Internal Covariate Shift
- Inception-v3：Rethinking the Inception Architechture for Computer Vision
- ResNet：Deep Residual Learning for Image Recognition，Residual Networks are Exponential Ensembles of Relatively Shallow Networks，Bridging the Gaps between Residual Learning, Recurrent Neural Networks and Visual Cortex
- SqueezeNet： AlexNet-level accuracy with 50x fewer parameters 
- ENet：A Deep Neural Network Architecture for Real-time semantic Segmentation
- 模块分析：Systematic evaluation of CNN advances on the ImageNet
- FractalNet：Ultra-Deep Neural Network without Residuals
- 如何结合模块：Neural Networks with differentiable structure


## 8. 读书计划

- 2018.12.17～2018.12.23: 复习完成机器学习所有算法
- 2019.08.12～2019.08.18: 学习操作系统知识、风控机器学习
- 2019.08.19～2019.08.25: 学习操作系统知识、数据结构与算法(学习hive、机器学习面试题)
     
     
## 9. 面试材料：
1. 笔记和面试题总结：md、ppt、纸质推导
   《机器学习》，周志华，机器学习方法理论
   《统计学习方法》，李航，统计学习理论性强
   《百面机器学习》
   《DeepLearning-500-questions》

2. 笔记和经典面试题总结
   leetcode
   《剑指offer》

3. 笔记和经典面试题总结
   《概率论》
