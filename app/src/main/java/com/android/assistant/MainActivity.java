package com.android.assistant;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImage();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_sign, R.id.navigation_dashboard, R.id.navigation_map)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }
    private void initImage(){
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("冶金与能源工程学院", "nengyuan");
        editor.putString("冶金与能源工程学院介绍", "能源工程学院是湘潭大学所属24个学院（教学部）之一。2008年9月10日，在湘潭大学庆祝毛泽东同志题写校名并指示“一定要把湘潭大学办好”暨建校五十周年之际，成立了能源工程学院。\n" +
                "　　学院现开设采矿工程、测绘工程、电子信息科学与技术、安全工程等4个本科专业，拥有测绘工程专业硕士点、煤矿安全培训中心和国家职业技能鉴定所，现有煤矿安全培训二级资质、煤矿生产能力核定资质、煤矿瓦斯等级鉴定资质和煤矿瓦斯防治能力评估资质等服务社会的平台，并广泛地开展了社会服务，取得较好的经济效益和社会效益。\n" +
                "　　学院现有专任教师70人，其中：高级职称38人；博士5人，硕士31人。近年来，学院参与国家级科研项目4个，主持或参与省级科研项目8个，省厅级课题6个，校级和横向课题21个，发明专利6项，专著5部，CSSCI、CSCD和核心刊物发表论文33篇，SCI、EI收录11篇。\n" +
                "　　学院拥有基础实验室、专业实验室46个，资料室专业藏书17万余册，各类期刊390余种。建有校园网络系统、计算机中心、实训中心、语音训练室和12个多媒体演播室。有1300多个座位的大礼堂和能容纳280余人的学术报告厅。学生宿舍实行公寓化管理。");
        editor.putString("信息与技术学院", "xinxi");
        editor.putString("信息与技术学院介绍", "学院现有教职工257名，其中专职教师169人，包括双聘院士1人、闽江学者特聘教授3人、闽江学者讲座教授1人、厦门大学特聘教授1人、教育部新世纪优秀人才支持计划入选者4人、国家百千万人才工程入选者1人；教授38人、副教授52人、博士生导师25人；103位教师具有博士学位， 35岁以下的教师占47%，形成一支学历学缘结构优化、梯队合理、极具发展潜力的人才队伍。目前，在校本科生1885人，硕士生854人，博士生121人。近年来，学院不断深化教学改革，优化课程体系，重视学生创新素质培养，院学生在“挑战杯”等国内外顶级大学生创新竞赛中摘金挂银，提高了学生综合素质。\n" +
                "目前学院承担着“十五”“211”重点建设项目—“电子信息技术”项目，在立体通信、智能信息处理、先进控制与制造业信息化、集成电路设计等方面开展研究。学院正承担着“985”二期平台建设项目，建设经费达5500万元人民币。同时，学院还承担一大批国家及地方纵向和横向科研课题。\n" +
                "信息科学与技术学院正在成长为学科建设主流化、办学理念特色化、科技创新规模化、人才培养复合化、师资队伍国际化的一流学院。 [1] ");
        editor.putString("经济与对外贸易学院", "jingji");
        editor.putString("经济与对外贸易学院介绍", "国际经济与贸易专业即国际经济与贸易 。\n" +
                "国际经济与贸易(International Economics and Trade 或 International Business and Trade )大学专业，该专业培养能较系统地掌握经济学基本原理和国际经济、国际贸易的基本理论，掌握国际贸易的基本知识和基本技能。了解中国对外贸易和当代国际经济贸易的发展现状，熟悉通行的国际贸易惯例与WTO规则，以及中国对外贸易的政策法规，了解主要国家与地区的对外贸易状况，能在涉外经济贸易部门、外资企业及政府机构和科研院所从事国际经济与贸易业务、管理、调研与教学科研等工作的复合型、应用型的高级专门人才。");
        editor.putString("机械与自动化学院", "jixie");
        editor.putString("机械与自动化学院介绍", "本专业主要是培养面向21世纪，适应社会主义现代化建设需要，具有创新精神和实践能力，德、智、体全面发展，面向基层并能胜任现代文秘工作的应用型专门人才。\n" +
                "1．政治思想方面：\n" +
                "热爱社会主义祖国，拥护中国共产党的领导，认真学习马列主义、毛泽东思想、邓小平理论和“三个代表” 重要思想，树立正确的世界观、人生观和价值观；团结协作，遵纪守法，具有良好的思想品德、社会公德、职业道德和为社会主义现代化建设服务的精神。\n" +
                "2．在专业知识和业务能力方面：\n" +
                "学生要掌握本类专业所必需的数理、电机与拖动、自动控制理论、工程制图、电工电子变流技术、控制技术等基础理论、基本知识和基本技能；具有一定的从事自动控制设备系统的安装、使用、检测、维修和简单设计的能力，具有解决本专业工作实际问题的能力；初步懂得组织生产管理的一般知识；了解本专业科学技术的新成就和发展趋势；具有一定的外语水平，能借助工具书阅读本专业外文资料；掌握计算机基础理论知识和基本操作技术。\n" +
                "3．具有一定的体育基本知识，掌握科学锻炼身体的基本技能，养成良好的体育锻炼和生活卫生习惯，达到国家规定的大学生体质健康标准，具有健康的体魄和良好的心理素质，能够履行建设祖国和保卫祖国的神圣义务，能精力充沛地工作。");
        editor.putString("生命与化工学院", "shengming");
        editor.putString("生命与化工学院介绍", "化工学院位于风景秀丽的北国江城——吉林市，是吉林省唯一一所化工类大学。学校在化工、机电等传统优势学科领域一直居于省内领先地位，学校是国家“卓越工程师教育培养计划”高校，CDIO工程教育联盟成员单位，现有教育部综合改革试点专业1个，国家级特色专业2个，吉林省品牌专业、特色专业、转型改革试点专业共18个，吉林省特色高水平专业6个，吉林省创新创业教育改革试点专业1个，国家级校外实践教育中心1个，省级校外实践教育中心2个，省级实验教学示范中心6个，省级大学生创新实践示范基地1个，省级人才培养模式创新实验区5个。2018年获国家级教学成果一等奖1项、省级教学成果奖7项。\n" +
                "学校成立于1958年，原隶属化工部，于2001年划归吉林省人民政府。\n" +
                "截至2017年3月，学校有两个校区，占地面积108.9万平方米，建筑面积34.56万平方米；教学科研仪器设备总值24378万元；馆藏图书115.6万册。设有研究生学院、14个教学院（部）和1个工程训练中心、1个分析测试中心，专业设置涵盖工、理、经、管、文、医6个学科门类，实现硕士、本科和高职多层次办学，全日制在校学生近1.6万人。 [1] ");
        editor.putString("食品与药理学院", "shipin");
        editor.putString("食品与药理学院介绍", "食品学院在我国同类学科中创建最早、基础最好、覆盖面最广，现拥有我国食品领域中唯一的食品科学与工程国家一级重点学科和食品科学与技术国家重点实验室，拥有国家功能食品工程技术研究中心、粮食发酵工艺与技术国家工程实验室、“国家食品企业质量安全检测技术示范中心（无锡）”，国家粮油标准研究验证中心等平台。在2012年教育部的全国一级学科评估中，食品科学与工程学科蝉联第一。2011年，食品科学与工程本科专业顺利通过了美国IFT国际食品专业认证，标志着江南大学食品人才培养已达到国际先进水平。 [1] \n" +
                "2018年10月26日，被教育部遴选为首批“三全育人”综合改革试点院（系）之一。 [2] ");
        editor.putString("探测与材料金属", "tance");
        editor.putString("探测与材料金属介绍", "学院（含学科）现有教师84人，工程实验人员18人，党政管理人员19人。教师中教授29人，副教授34人，教授中博士导师15人。目前学院在校生中本科生761，硕士研究生150人，博士研究生92人。\n" +
                "　　尽管地探学院很年轻，但是地球物理系是原长春地质学院1952年创建时即成立的主要系之一。地球物理系前三任系主任分别是著名地球物理学家、学部委员（院士）顾功叙，著名物理学家、学部委员（院士）余瑞璜和著名地质学家、院士业治铮。这些科学大师为地球物理系以后的发展奠定了坚实的基础。\n" +
                "　　以地球物理系为主的学院各专业（学科）先后共培养各类专业人才8000余人，其中本科生6000人，专科生1000余人，近1000名硕士、博士研究生和博士后，其中包括10余名外国留学生。各层次毕业生由于基础理论扎实和实践能力强，受到用人单位的欢迎。其中很多人在各工作岗位上成为总工程师、博士生导师、知名学者和各级领导人员。地球物理系 本科毕业生中有三位成为中国科学院、中国工程院院士。");
        editor.putString("体育与人体健美学院", "tiyu");
        editor.putString("体育与人体健美学院介绍", "成都体育学院始建于1942年，前身系四川省立体育专科学校，1950年人民政府接管，更名为成都体育专科学校。1953年全建制转为西南体育学院，1956年更为成都体育学院，1961年重庆体育学院并入。学校原隶属国家体育总局，2001年划转地方，实行国家体育总局与四川省人民政府共建，以四川省管理为主的全日制普通高等院校。 [1] \n" +
                "据2017年8月学校官网信息显示，学校占地总面积48万平方米，学校为博士学位授予单位，共设4院9系1部2校共16个教学单位。以本科教育为主，开设了18个本科专业，跨教育学、医学、文学、管理学、经济学、理学、艺术学等7大学科门类。有全日制本科生9000余人，博士与硕士研究生1100余人。现有各类在岗教职工1200多人，其中专任教师600余人，高级职称240余人，中级职称270多人，国际和国家级裁判、运动健将各100余人。 [2] ");
        editor.putString("通信与电力工程学院", "tongxin");
        editor.putString("通信与电力工程学院介绍", "学院的办学历史可追溯到1956年建校（成都电讯工程学院）初期的有线电设备系，其主体是有线电、电报电话和通信三个专业。1958年在专门化基础上建立了电视、微波多路通信、电子测量技术专业。自1977年恢复高考和高校秩序正常化以来，学校对专业重新进行了调整，成立了无线电技术系，为人们熟知的老一系。设有无线电技术、广播电视工程、通信工程、电子测量专业。二十世纪90年代以来随着我国通信产业学习和引进国外先进技术与先进管理经验，进行大规模的改造，1995年3月25日正式挂牌成立由三个系：（无线电技术系、通信工程、信息工程系）和两个国家级实验室（宽带光纤传输与通信系统、战术通信抗干扰技术）和信息系统研究所组成。\n" +
                "今天的通信学院，在教学规模不断扩大、教学水平大大提高的同时，科研工作也取得了长足发展，教学和科研已成为学院发展的两个中心。现在学院拥有一个国家级重点实验室（抗干扰通信技术国防科技重点实验室）、一个教育部重点实验室（宽带光纤传输与通信网技术重点实验室）、三个省部级重点实验室（通信与信息系统四川省重点实验室");
        editor.putString("服装设计与艺术学院", "fuzhuang");
        editor.putString("服装设计与艺术学院介绍", "服装学院（Beijing Institute Of Fashion Technology），是中国一所以服装命名，艺工为主，艺、工、经、管等多学科协调发展的全日制普通高等学校，学校入选教育部第二批卓越工程师教育培养计划高校，为全国深化创新创业教育改革示范高校、教育部创新创业工作典型经验高校、首批北京市深化创新创业教育改革示范高校。 [1-2] \n" +
                "学校始建于1959年，原名北京纺织工学院，1961年更名为北京化学纤维工学院，1987年改扩建为北京服装学院，1998年由纺织工业部划转北京市为主管理。 [2] \n" +
                "截至2018年11月，学校有三个校区：樱花园校区、芍药居校区、牡丹园校区，另与昌平区北七家镇商务部培训中心联合办学共建北校区；设有9个全日制本科教学学院，开设30个本科专业；有教职工843人，全日制本科生6058人，全日制硕士研究生1071人，非全日制硕士研究生3人，同等学力申请硕士学位人员72人，博士研究生24人，留学生60人。 [3] ");
        editor.putString("医学与生命安全学院", "yixue");
        editor.putString("医学与生命安全学院介绍", "学院于1959年被定为全国16所重点高等学府之一，并于1997年入选首批211工程。2000年，上海医科大学和复旦大学合并办学，组建成为新的复旦大学。2012年，新的上海医学院成立，作为复旦大学党政的派出机构，根据学校的授权，在大医口的人才培养、科学研究、学科建设、发展规划、资源配置、对外交流等方面，行使相对独立的管理权限。2018年12月21日，教育部、国家卫生健康委员会、上海市人民政府正式签约，共建托管复旦大学上海医学院及其直属附属医院。 [1] \n" +
                "据2018年12月学院官网显示，学院有直属院系所9个，附属医院16所（含筹）。设有本科专业9个，高职专业1个。有博士学位授予权的一级学科9个，设有博士后科研流动站8个。有博士研究生2514人，硕士研究生2 687人，普通本科生3871人，专科生281人。有一级学科国家重点学科3个，二级学科国家重点学科12个。有国家重点实验室1个，教育部重点实验室5个，国家卫健委重点实验室9个，上海市重点实验室9个。 [1] ");
        editor.putString("影视与摄像学院", "yingshi");
        editor.putString("影视与摄像学院介绍", "学院积极开展国际文化艺术交流，现已举办过美国、德国、波兰、西班牙、加拿大、法国、澳大利亚等多国电影周。西班牙驻华大使馆佩雷斯女士、20世纪FOX电影公司副总Greg Lombard、加拿大电影局总裁Tom Perlmutter、德国导演VolkerSchlndorff、以色列导演Dan Wolman、荷兰导演Pieter Fleury、德国资深演员Antoine Monot Jr、著名特效大师Richard Taylor等均莅临学院访问讲学。美国中俄克拉荷马大学更是多次来院访问，并签订共建影视基地战略合作协议。\n" +
                "2015年底，该校与北京电影学院签署战略合作协议。双方将在学科专业建设、师资培养、尖子生培育、研究生教育、教育资源共享、作品联创等方面开展全方位合作。\n" +
                "2016年9月，该校与松下电器（中国）有限公司签订战略合作协议。双方将共建松下广电教学及产品体验基地。松下不仅将为学院提供先进设备，还将在摄制基地共建、专业设施改造乃至专业教学等方面深入学院教育教学。同年11月，川影院领导应索尼专业系统集团总裁邀请访问索尼公司总部，双方正式达成战略合作备忘录，将在“婚庆艺术教学与技术培训基地”项目、设备改造、实务教学、技术推广等领域展开合作。同时，川影在国内的长期合作伙伴华侨城集团也将在“双创园”建设、“安仁电影城”项目及文化艺术产业联合开发等方面与学院展开更深入合作。");
        editor.putString("兰亭书法艺术学院", "shufa");
        editor.putString("兰亭书法艺术学院介绍", "书法学院是河北美术学院的直属院系。学院坚持走“研究传统、立足当代”的道路，推行“博闻、明理、优术”的教学理念，强调国学基础，重视文化修养，突出理论与实践 、基础与个性、综合与专精相结合，逐渐形成富有学院特色的书法教育教学体系。学院以培养具有创作实践与学术研究能力的专门人才为目标。\n" +
                "学院采取培养和引进等多种形式加强师资队伍建设，形成了一支高水平的师资队伍。学院现有专兼职教师160余名。聘请了韩羽、周俊杰、何应辉、刘正成、胡抗美、沃兴华、曾翔、张羽翔、李强、范硕、吕金光等著名书法家为教授。特色鲜明的教育教学在全省乃至全国产生很大影响。\n" +
                "书法学院现有在校学生一千三百余人。近年来，已有学生百余人次在中国书协主办的“全国展”“兰亭奖”以及“单项展”中获奖、入展。");
        editor.putString("学术与研究学院", "xueshu");
        editor.putString("学术与研究学院介绍", "受传统教育观念的影响，我国高等教育重视学术型院校发展而忽视职业教育型院校发展，政府有关部门在教育资源调配上倾向于学术型院校，这使社会形成学术型院校优于职业教育型院校的偏见，造成社会对职业教育的歧视，影响着人们对职业教育重要性的认知。很多考生宁愿上就业率极低的学术型院校，也不愿上就业率很高的职业教育型院校。 [2] 受传统教育观念的影响，我国高等教育重视学术型院校发展而忽视职业教育型院校发展，政府有关部门在教育资源调配上倾向于学术型院校，这使社会形成学术型院校优于职业教育型院校的偏见，造成社会对职业教育的歧视，影响着人们对职业教育重要性的认知。很多考生宁愿上就业率极低的学术型院校，也不愿上就业率很高的职业教育型院校。 [2] 受传统教育观念的影响，我国高等教育重视学术型院校发展而忽视职业教育型院校发展，政府有关部门在教育资源调配上倾向于学术型院校，这使社会形成学术型院校优于职业教育型院校的偏见，造成社会对职业教育的歧视，影响着人们对职业教育重要性的认知。很多考生宁愿上就业率极低的学术型院校，也不愿上就业率很高的职业教育型院校。 [2] ");
        editor.putString("社会与交通管理学院", "jiaotong");
        editor.putString("社会与交通管理学院介绍", "（一）政治思想和德育方面\n" +
                "热爱社会主义祖国，拥护中国共产党的领导，掌握马克思列宁主义、毛泽东思想、邓小平理论和“三个代表”重要思想的基本原理，牢固树立科学发展观；热爱公安事业，忠于党、忠于人民、忠于国家、忠于法律；具有爱国守法、明理诚信、团结友善、勤俭自强、敬业奉献的品质；具有良好的思想品德、社会公德和职业道德，树立社会主义荣辱观。 [1] \n" +
                "（二）专业方面\n" +
                "本专业主要是通过公安技术学、公安学、政治学、法学和交通运输学等方面的基本理论和基本知识的学习，以及通过交通调查、交通指挥、交通违法行为处理、交通事故处理、平面交叉口交通组织优化等方面的基本训练与实践活动，掌握公安交通管理的基本技能与基本方法。本专业毕业生应获得以下几个方面的知识、技能与素养。\n" +
                "1．掌握公安技术学、公安学、政治学、法学和交通运输学等方面的基本理论和基本知识。\n" +
                "2．系统掌握公安交通管理的基础理论、基本知识与专业技术知识。具有交通安全宣传、交通指挥、交通组织优化、处理交通违法行为、处理交通事故能力。");
        editor.putString("提醒", "1");
        editor.apply();
    }
}
