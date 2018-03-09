drop table if exists deliver;
drop table if exists collect_tag;
drop table if exists collect_enterprise;
drop table if exists review;
drop table if exists inform_interview;
drop table if exists manager;
drop table if exists recruit_info_tag;
drop table if exists recruit_info;
drop table if exists tag;
drop table if exists enterprise;
drop table if exists student_detail;
/*drop table if exists resume_skill;
drop table if exists resume_club;
drop table if exists resume_organization;
drop table if exists resume_works;
drop table if exists resume_education;
drop table if exists resume_head;*/
drop table if exists resume;
drop table if exists student;

create table student(
	student_id  				BIGINT(20) AUTO_INCREMENT,
	user_name  					VARCHAR(20),
	mailbox  					VARCHAR(30),
	password  					VARCHAR(200),
	primary key(student_id)				
);
create table resume(
	resume_id 					BIGINT(20) AUTO_INCREMENT,
	student_id  				BIGINT(20),
	resume_content				VARCHAR(5000),
	primary key(resume_id),
	foreign key(student_id) references student(student_id)
);
/*create table resume_head(
	resume_id  					BIGINT(20),
	name  						VARCHAR(20),
	address  					VARCHAR(50),
	phone_num  					CHAR(11),
	mailbox  					VARCHAR(30),
	primary key(resume_id),
	foreign key(resume_id) references resume(resume_id)
);
create table resume_education(
	resume_education_id  		BIGINT(20) AUTO_INCREMENT,
	resume_id  					BIGINT(20),
	university_name    			VARCHAR(30),
	city  						VARCHAR(30),
	province  					VARCHAR(10),
	major  						VARCHAR(25),
	graduate_date   			DATE,
	grade  						int,
	honors   					VARCHAR(100),
	related_course  			VARCHAR(200),
	primary key(resume_education_id),
	foreign key(resume_id) references resume(resume_id) 
);*/
/*create table resume_works(
	resume_works_id  			BIGINT(20) AUTO_INCREMENT,
	resume_id  					BIGINT(20),
	company  					VARCHAR(30),
	city  						VARCHAR(30),
	province  					VARCHAR(10),
	job_name  					VARCHAR(20),
	project_name  				VARCHAR(30),
	start_date  				DATE,
	end_date  					DATE,
	sentence_1  				VARCHAR(100),
	sentence_2  				VARCHAR(100),
	sentence_3  				VARCHAR(100),
	sentence_4  				VARCHAR(100),
	primary key(resume_works_id),
	foreign key(resume_id) references resume(resume_id)  					
);
create table resume_organization(
	resume_organization_id  	BIGINT(20) AUTO_INCREMENT,
	resume_id  					BIGINT(20),
	name  						VARCHAR(30),
	job_name  					VARCHAR(20),
	start_date  				DATE,
	end_date  					DATE,
	sentence_1  				VARCHAR(100),
	sentence_2  				VARCHAR(100),
	sentence_3  				VARCHAR(100),
	primary key(resume_organization_id),
	foreign key(resume_id) references resume(resume_id) 
);
create table resume_club(
	resume_club_id  			BIGINT(20) AUTO_INCREMENT,
	resume_id  					BIGINT(20),
	name  						VARCHAR(30),
	job_name  					VARCHAR(20),
	start_date  				DATE,
	end_date  					DATE,
	sentence_1  				VARCHAR(100),
	sentence_2  				VARCHAR(100),
	primary key(resume_club_id),
	foreign key(resume_id) references resume(resume_id) 
);
create table resume_skill(
	resume_skill_id  			BIGINT(20) AUTO_INCREMENT,
	resume_id  					BIGINT(20),
	language  					VARCHAR(30),
	computer  					VARCHAR(30),
	hobby  						VARCHAR(100),
	primary key(resume_skill_id),
	foreign key(resume_id) references resume(resume_id) 
);*/
create table student_detail(
	student_id  				BIGINT(20),
	student_mailbox  			VARCHAR(30),
	phone_num  					CHAR(11),
	university_name  			VARCHAR(30),
	major  						VARCHAR(25),
	grade  						VARCHAR(10),
	intention_city  			VARCHAR(300),
	intention_industry  		VARCHAR(300),
	intention_function  		VARCHAR(300),
	validation  				BOOLEAN,
	primary key(student_id),
	foreign key(student_id) references student(student_id)
);
create table enterprise(
	enterprise_id  				BIGINT(20) AUTO_INCREMENT,
	user_name  					VARCHAR(20),
	name  						VARCHAR(30),
	mailbox  					VARCHAR(30),
	phone_num  					VARCHAR(30),
	password  					VARCHAR(200),
	enterprise_introduction  	VARCHAR(500),
	icon_address  				VARCHAR(150),
	primary key(enterprise_id)
);
create table tag(
	tag_id  					int AUTO_INCREMENT,
	name  						VARCHAR(20),
	primary key(tag_id)
);
create table recruit_info(
	recruit_info_id  			BIGINT(20) AUTO_INCREMENT,
	enterprise_id  				BIGINT(20),
	job_name  					VARCHAR(20),
	job_describe  				VARCHAR(500),
	job_require  				VARCHAR(500),
	location  					VARCHAR(50),
	low_salary  				int,
	high_salary   				int,
	date_time  					timestamp,
	deadline  					VARCHAR(30),
	have_delete  				BOOLEAN,
	primary key(recruit_info_id),
	foreign key(enterprise_id) references enterprise(enterprise_id)
);
create table recruit_info_tag(
	recruit_info_id  			BIGINT(20),
	tag_id  					int,
	primary key(recruit_info_id,tag_id),
	foreign key(recruit_info_id) references recruit_info(recruit_info_id),
	foreign key(tag_id) references tag(tag_id)
);
create table manager(
	manager_id  				int AUTO_INCREMENT,
	user_name  					VARCHAR(20),
	password  					VARCHAR(200),
	primary key(manager_id)
);

create table inform_interview(
	inform_interview_id  		BIGINT(20) AUTO_INCREMENT,
	enterprise_id  				BIGINT(20),
	student_id  				BIGINT(20),
	content  					VARCHAR(500),
	date_time  					timestamp,
	primary key(inform_interview_id),
	foreign key(enterprise_id) references enterprise(enterprise_id),
	foreign key(student_id) references student(student_id)
);
create table review(
	review_id					BIGINT(20),
	enterprise_id  				BIGINT(20),
	student_id  				BIGINT(20),
	job_name  					VARCHAR(20),
	content  					VARCHAR(500),
	date_time  					timestamp,
	primary key(review_id),
	foreign key(enterprise_id) references enterprise(enterprise_id),
	foreign key(student_id) references student(student_id)
);
create table collect_enterprise(
	student_id  				BIGINT(20),
	enterprise_id  				BIGINT(20),
	primary key(enterprise_id, student_id),
	foreign key(student_id) references student(student_id),
	foreign key(enterprise_id) references enterprise(enterprise_id)
);
create table collect_tag(
	student_id  				BIGINT(20),
	tag_id  					int,
	primary key(tag_id, student_id),
	foreign key(student_id) references student(student_id),
	foreign key(tag_id) references tag(tag_id)
);
create table deliver(
	deliver_id  				BIGINT(20) AUTO_INCREMENT,
	resume_id  					BIGINT(20),
	enterprise_id  				BIGINT(20),
	recruit_info_id  			BIGINT(20),
	date_time  					timestamp,
	have_read  					BOOLEAN,
	have_delete  				BOOLEAN,
	primary key(deliver_id),
	foreign key(resume_id) references resume(resume_id),
	foreign key(enterprise_id) references enterprise(enterprise_id),
	foreign key(recruit_info_id) references recruit_info(recruit_info_id)
);

insert into manager
	values(0, 'admin', 'E228C3B57EA3A4DD9FBB68D9ACEDA997F8BD1C4E7230B1016E3341B39D2FE6EF3A1178F0482C8FE2F9F9C5B4B2395B19E56D6BA8617828E79FC1773FC5DF40DC30DBEDCA387C431929C646D69B2F9F7A');

insert into student
	values(1,'syunk','408271272@qq.com','3277E8DD42812340F56B2997A9C6E801F9AE2C5DAA954DED676C6F1B8297A879B75185943D90B146C07401A0EBF57543533C646C0AB40D9C3035454757B92FA5CF278EE04F8D634D5E984371425E9179');

insert into enterprise
	values(1,'baidu','百度','mbaidu@baidu.com','86-10-5992 8888','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'百度是一家持续创新的,以"用科技让复杂世界更简单"为使命的高科技公司','/public/assets/img/comlogo/baidu.png'),
	(2,'aiqiyi','爱奇艺','maiqiyi@aiqiyi.com','86-10-8000 6459','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'爱奇艺是一家为了视频事业而献身的伟大公司','/public/assets/img/comlogo/aiqiyi.png'),
	(3,'4399','4399','m4399@4399.com','86-10-4566 8885','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'4399是中国最早的和领先的在线休闲小游戏平台，从建立至今，4399坚持的是用户第一，以"用户体验"为核心的建站模式，免费为用户提供各种绿色、安全、健康的游戏，不断完善服务策略，赢得了众多忠实的用户',
		'/public/assets/img/comlogo/4399.png'),
	(4,'ebay','易贝','mebay@ebay.com','86-10-5864 6946','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'eaby是一个管理可让全球民众上网买卖物品的线上拍卖及购物网站。ebay于1995年9月4日由Pierre Omidyar以Auctionweb的名称创立于加利福尼亚州圣荷西。人们可以在ebay上通过网络出售商品','/public/assets/img/comlogo/ebay.png'),
	(5,'IBM','IBM','mibm@ibm.com','86-10-8889 6465','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'IBM（国际商业机器公司）或万国商业机器公司，简称IBM（International Business Machines Corporation）。总公司在纽约州阿蒙克市','/public/assets/img/comlogo/IBM.png'),
	(6,'TCL','TCL','mtcl@tcl.com','86-10-6494 4646','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'TCL集团股份有限公司创立于1981年，是全球化的智能产品制造及互联网应用服务企业集团。集团现有8万多名员工，23个研发机构，21个制造基地，在80多个国家和地区设有销售机构，业务遍及全球160多个国家和地区','/public/assets/img/comlogo/TCL.pgn'),
	(7,'alibaba','阿里巴巴','malibaba@alibaba.com','86-10-4564 7789','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'阿里巴巴网络技术有限公司（简称：阿里巴巴集团）是以曾担任英语教师的马云为首的18人于1999年在杭州创立，他们相信互联网能够创造公平的竞争环境，让小企业通过创新与科技扩展业务，并在参与国内或全球市场竞争时处于更有利的位置。[1] 
阿里巴巴集团经营多项业务，另外也从关联公司的业务和服务中取得经营商业生态系统上的支援。业务和关联公司的业务包括：淘宝网、天猫、聚划算、全球速卖通、阿里巴巴国际交易市场、1688、阿里妈妈、阿里云、蚂蚁金服、菜鸟网络等
','/public/assets/img/comlogo/alibaba.png'),
	(8,'baidumap','百度地图','mbaidumap@baidumap.com','86-10-9999 7746','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'百度地图是百度提供的一项网络地图搜索服务，覆盖国内近400个城市、数千个区县。2014年12月15日，百度与诺基亚达成协议，未来诺基亚地图及导航业务Here将向百度提供中国内地以外的地图数据服务','/public/assets/img/comlogo/baidumap.png'),
	(9,'baoma','宝马','mbaoma@baoma.com','86-10-9859 7646','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'宝马公司创建于1916年，总部设在德国慕尼黑。BMW的蓝白标志宝马总部所在地巴伐利亚州州旗的颜色。百年来，宝马汽车由最初的一家飞机引擎生产厂发展成为以高级轿车为主导，并生产享誉全球的飞机引擎、越野车和摩托车的企业集团，名列世界汽车公司前列。宝马也被译为“巴依尔”','/public/assets/img/comlogo/baoma.png'),
	(10,'danone','达能','mdanone@danone.com','86-10-9799 7346','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'达能集团总部设于法国巴黎的是一个业务极为多元化的跨国食品公司，集团的业务遍布六大洲、产品行销100多个国家。1996年集团的总营业额达到839亿法郎。 在法国、意大利及西班牙，达能集团都是最大的食品集团，达能亦是当今欧洲第三大食品集团，并列全球同类行业前六名','/public/assets/img/comlogo/danone.png'),
	(11,'dazhong','大众','mdazhong@dazhong.com','86-10-4444 7254','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'大众汽车（德语：Volkswagen）是一家总部位于德国沃尔夫斯堡的汽车制造公司，也是世界四大汽车生产商之一的大众集团的核心企业','/public/assets/img/comlogo/dazhong.png'),
	(12,'didi','滴滴出行','mdidi@didi.com','86-10-9999 7746','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'滴滴出行是涵盖出租车、[1]  专车、[2]  快车、[3]  顺风车、[4]  代驾及[5]  大巴等多项业务在内的一站式出行平台','/public/assets/img/comlogo/didi.png'),
	(13,'Neusoft','东软','mneusoft@neusoft.com','86-10-7786 7566','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'东软集团是中国领先的IT解决方案与服务供应商，是上市企业，股票代码600718。公司成立于1991年，前身为东北大学下属的沈阳东大开发软件系统股份有限公司和沈阳东大阿尔派软件有限公司','/public/assets/img/comlogo/Neusoft.png'),
	(14,'hongbanbao','红板报','mhongbanbao@hongbanbao.com','86-10-9779 7556','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'','/public/assets/img/comlogo/hongbanbao.png'),
	(15,'hunanweishi','湖南卫视','mhunanweishi@hunamweishi.com','86-10-9999 7746','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'湖南卫视的全称是湖南广播电视台卫星频道，昵称芒果台，是湖南广播电视台和芒果传媒有限公司旗下的卫星电视频道','/public/assets/img/comlogo/hunanweishi.png'),
	(16,'jiritoutiao','今日头条','mjinritoutiao@jiritoutiao.com','86-10-9999 7746','DC7BE88AB13D57CB571C0449D2DC75F9DFA8066B820A451139712FFF99880144A11901878A4CA6F50A319CF4704963920ED97D4B765A776D7010D637728056744061575798B6686695464C3DDB165CDB',
		'今日头条是一款基于数据挖掘的推荐引擎产品，它为用户推荐有价值的、个性化的信息，提供连接人与信息的新型服务，是国内移动互联网领域成长最快的产品服务之一','/public/assets/img/comlogo/jinritoutiao.png');

insert into student_detail
	values(1,'2015141463140@stu.scu.edu.cn','17761279281','四川大学','软件工程',2015,'[上海,成都]','[互联网]','[项目管理,技术]',0);

insert into resume
	values(1,1,null);

insert into tag
	values(1,'互联网');

insert into collect_enterprise
	values(1,1);

insert into collect_tag
	values(1,1);

insert into recruit_info
	values(1,1,'项目经理','指导项目进行','这是要求：我没写','南京','120000','240000','2017-06-12 17:52:08','2017-06-11',0);

insert into recruit_info_tag
	values(1,1);

