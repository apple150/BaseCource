-- MySQL dump 10.13  Distrib 5.6.21, for Win32 (x86)
--
-- Host: localhost    Database: webnews
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `category` varchar(30) NOT NULL,
  `title` varchar(80) NOT NULL,
  `annotation` varchar(200) NOT NULL,
  `author` varchar(30) NOT NULL,
  `agency` varchar(30) NOT NULL,
  `drelease` date NOT NULL,
  `document` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'ПОЛИТИКА','Россия предлагает ООН закрепить неприемлемость госпереворотов','Россия предлагает закрепить неприемлемость госпереворотов как средства смены власти, об этом заявил министр иностранных дел РФ Сергей Лавров на пресс-конференции по итогам 2014 года','Татьяна Гусева','ТАСС','2015-01-21','Мы предложили на последней сессии ООН принять резолюцию о неприемлемости государственного переворота как средства смены власти. Такие нормы действуют в Африканском союзе, в интеграционных объединениях Латинской Америки, - добавил он.\r\nПриведу одну цитату: США категорически осуждают любую попытку захвата власти неконституционным путем. Это сказано о попытке государственного переворота в Гамбии. Про Украину этого сказано не было, было сказано, что народ восстал против ненавистного правительства, - отметил Лавров.\r\nБудет нечестно и недостойно применять одни критерии для Гамбии, а другие - ко всем остальным, - считает он.'),(2,'ПОЛИТИКА','Россию нам никто не заменит','Беларусь, установив многоформатные отношения с Россией, продолжит сотрудничество с ней как с очень близким, братским государством','Алина Гришкевич','БЕЛТА','2015-01-15','Высказываясь на тему белорусско-российских отношений, глава государства отметил: Россию нам никто не заменит. И когда мы ведем диалог с Западом, с ЕС, с Америкой, другими, мы задаем один вопрос, и я об этом открыто говорю, – вы нам замените Россию? Нет. Тогда зачем вы нас в это тянете? На примере братской Украины мы уже убедились, во что это выливается в крайнем случае.\r\nПо словам Александра Лукашенко, Беларусь теснейшим образом связана с Россией исторически и экономически. И когда нам было трудно, как бы там ни было, чего бы это нам ни стоило, Россия всегда подставляла свое плечо. Но не без проблем, которые, кстати, создавались на ровном месте, – сказал президент.\r\nПри этом он подчеркнул, что Беларусь всегда открыто заявляет о своей позиции и никогда не вела себя предательски по отношению к России.'),(3,'ПОЛИТИКА','Нас беспокоят трудности в России и Беларуси','Проблемы Беларуси и России беспокоят Литву, заявила президент этой страны Даля Грибаускайте','Наталья Костюкевич','DELFI','2014-12-29','Президент Литвы также отметила, что никто не желает России зла, а диалог с ней возможен только тогда, когда Украина восстановит свою территориальную целостность.\r\nБеда на самом деле касается всех: когда начинаются военные действия, когда начинается напряжение и когда одна страна начинает вести себя агрессивно по отношению к другой, соседней стране – это беда. И конечно, если одна страна не чувствует себя в безопасности и пытается эту свою небезопасность выплеснуть за счет повышения собственной агрессии, через аннексию территории, через войны, вне всяких сомнений – это беда для всех. И голодный, злой сосед, несомненно, это плохо, и те трудности, которые начинаются у наших соседей – не только в России, в Беларуси – это беспокоит. И уж точно никто не желает зла нашим соседям и этим странам, поэтому Европа и мы готовы всегда оставить двери открытыми для диалога. Но диалог возможен только тогда, когда агрессия завершится, когда Украина восстановит свою территориальную целостность, – сказала Грибаускайте.\r\nНа вопрос о том, как она видит будущее Украины, президент Литвы ответила, что сейчас для этой страны важно заново начать ориентацию на Запад, а Евросоюзу – помочь ей это сделать.\r\nСама Украина приняла решение именно голосованием собственных людей на улицах – именно жители Украины повернули страну на Запад, правительство пытается это делать, но это долгий, болезненный и очень сложный путь. Евросоюз и мы, Литва, готовы помочь этому народу, ведь сегодняшняя Украина борется не только за себя и за собственную территориальную целостность, не только за собственную свободу, но и за свободу всей Европы – за свободу всех нас тоже. Поэтому дешевле и проще для нас помочь Украине, чем потом, возможно, делать это и на территории своей страны, – сказала Грибаускайте.'),(4,'ПОЛИТИКА','Встречи контактной группы в Минске 16 января не будет','Встречи трехсторонней контактной группы по Украине в Минске 16 января не будет, об этом сообщил пресс-секретарь МИД Беларуси Дмитрий Мирончик','Станислав Коршунов','LENTA.RU','2015-01-16','Мы подтверждаем нашу готовность обеспечить условия для очередного раунда переговоров. Для того чтобы он состоялся, как мы рассчитываем, в ближайшее время, сторонам необходимо согласовать дату встречи, – сказал Мирончик.\r\nНапомним, ранее стороны заявляли о возможности проведения очередной встречи контактной группы 16 января в Минске.\r\nПо сообщению пресс-службы ОБСЕ, контактная группа из представителей самой организации, Украины и России 15 января провела встречу в Киеве перед консультациями с представителями ЛНР и ДНР.\r\nТрехсторонняя контактная группа, состоящая из представителей Украины, Российской Федерации и ОБСЕ, провела встречу 15 января в Киеве в рамках подготовки к запланированным консультациям группы с представителями некоторых районов Донецкой и Луганской областей в Минске, – говорится в сообщении.\r\nПо заявлению ОБСЕ, контактная группа готова к консультациям и ждет подтверждения присутствия всех сторон, подписавших минские соглашения.\r\nРанее второй президент Украины Леонид Кучма, который представляет официальный Киев на переговорах контактной группы, заявил, что встреча возможна только при участии глав самопровозглашенных ДНР и ЛНР Александра Захарченко и Игоря Плотницкого, которые и подписали минские соглашения.\r\nВместо них на переговоры в Минск выехали, по их собственным словам, от ДНР – Денис Пушилин, от ЛНР – Владислав Дейнего. Последний в комментарии ТАСС и вовсе заявил, что уже находится в Минске и был поставлен в известность о том, что встреча сегодня не состоится. Пушилин заявил, что встреча не начинается из-за отсутствия представителя Украины. По словам Пушилина, его сторона планирует поднять на переговорах такие вопросы, как прекращение огня на линии соприкосновения, обмен пленными и статус Донбасса.\r\nНапомним, последняя встреча контактной группы в Минске состоялась 24 декабря. На ней была достигнута договоренность о большом обмене пленными. Намеченное на 26 декабря продолжение переговоров не состоялось.\r\nДо этого переговоры контактной группы проходили в белорусской столице трижды. Первое заседание состоялось 31 июля в резиденции Заславль под Минском. Стороны обменялись условиями для прекращения огня на востоке Украины. Более результативными стали сентябрьские встречи. 5 сентября договорились о режиме прекращения огня на Донбассе, об обмене пленными и доставке гуманитарной помощи. 19 сентября стороны решили развести войска под контролем ОБСЕ.'),(5,'ЭКОНОМИКА','На торгах 20 января рубль продолжил укрепляться','20 января на Белорусской валютно-фондовой бирже прошли очередные торги валютами. Белорусский рубль продолжил курс на укрепление','Артем Шрайбман','TUT.BY','2015-01-20','Курс доллара снизился еще на 20 рублей до 14 830 рублей. Уже несколько сессий кряду американская валюта дешевеет, достигнув своего пика в 15 010 рублей 14 января. \r\nПо сравнению с понедельничной сессией евро подешевел на 30 рублей до 17 170 рублей. \r\nКурс российского рубля не изменился и составил 228,5 белорусского рубля.'),(6,'ЭКОНОМИКА','Газпром закрывает представительство в Минске из-за ненадобности','Совет директоров Газпрома 29 января рассмотрит вопрос о ликвидации представительства компании в Минске','Валентина Лайкова','ИНТЕРФАКС','2015-01-19','Необходимости в работе представительства больше нет, так как в Беларуси у Газпрома полноценно функционирует 100-процентное дочернее общество Газпром трансгаз Беларусь, - пояснили TUT.BY в управлении информации российской газовой монополии. \r\nПредставительство Газпрома было открыто в Минске в декабре 1998 года. Целью работы представительства является защита и представление интересов ОАО Газпром и его дочерних обществ на территории республики, сказано на сайте компании. \r\nВ конце 2011 года Газпром довел до 100% свою долю акций в Белтрансгазе (в настоящее время Газпром трансгаз Беларусь). Кроме того, в Беларуси с 2009 года функционирует Газпромнефть-Белнефтепродукт - дочернее предприятие компании Газпром нефть. Газпром также является основным акционером Белгазпромбанка. \r\nЛиквидация газпромовского представительства в Беларуси не имеет никакого отношения к строительству башни Газпрома на месте Московского автовокзала в Минске, сказал источник в российской газовой компании. \r\nСкорее всего, перемены связаны с устранением дублирующих структур в системе Газпрома и оптимизацией общих затрат российской компании. Газпром оценивает общий эффект программы сокращения затрат на 2015 год в 13,1 млрд российских рублей.'),(7,'ЭКОНОМИКА','Экспорт белорусских товаров в Россию сократился на 1 млрд долларов','Экспорт десяти основных белорусских товаров в Россию в январе-ноябре 2014 года сократился на 1 млрд долларов','Дмитрий Заяц','БелаПАН','2015-01-13','Экспорт тракторов и седельных тягачей снизился на 172,5 млн долларов, молока и сливок — на 166 млн долларов, грузовых автомобилей — на 145,9 млн долларов, шин — на 117,8 млн.\r\nТакже существенно уменьшился экспорт в РФ машин для уборки сельхозкультур (на 88,7 млн долларов), металлопродукции — стальных прутков (на 83,3 млн ).\r\nПоставки колбас и аналогичных продуктов из мяса сократились на 70,4 млн долларов, свинины — на 60,8 млн долларов.\r\nНаряду с этим зафиксировано снижение экспорта в Россию телевизоров и автобусов.\r\nВ ноябре 2014 года по сравнению с октябрем валютные поступления (выручка) от экспорта белорусских товаров в Россию снизилась на 266,8 млн долларов до 1 млрд 76,2 млн долларов.\r\nПо мнению экспертов, снижение валютных поступлений от экспорта белорусских товаров в Россию обусловлено рядом причин, в первую очередь ускорением темпов девальвации российского рубля в четвертом квартале 2014 года, в результате чего экспортная выручка Беларуси в долларовом выражении стала уменьшаться. \r\nВыступая в ноябре в Палате представителей, бывший премьер-министр Михаил Мясникович констатировал, что из-за снижения цен (в долларовом выражении) на рынке России белорусским экспортерам приходится искать другие географические направления сбыта своей продукции.\r\nКроме того, осенью 2014 года многим белорусским производителям мясо-молочной продукции были запрещены поставки на российский рынок. \r\nУстановленные ограничения российские власти мотивировали тем, что партии белорусской продукции не соответствуют санитарным нормам и требованиям, предусмотренным российским законодательством.'),(8,'СПОРТ','Минское Динамо забросило в гостях Словану шесть шайб','Хоккеисты минского Динамо ярко начали выездное турне, одолев в Братиславе местный Слован','Денис Алдохин','РИА Новости','2015-01-21','Зубры уверенно начали встречу и быстро повели 2:0 благодаря голам Павла Развадовского и Мэтт Эллисона. Впрочем, удержать преимущество гостям не удалось: форварды Слована Жига Еглич и Либор Гудачек дважды реализовали большинство.\r\nВо втором периоде минчане вновь увеличили преимущество до двух голов после точных бросков Мэтта Эллисона и Пола Щехуры, на что хозяева ответили голом бывшего динамовца Ладислава Надя.\r\nВ начале заключительной трети матча команды обменялись голами: на шайбу Лукаша Крайчека словаки ответили голом Рока Тичара. Окончательный же счет в матче установил забросивший первую шайбу за Динамо с игры Андрей Степанов.'),(9,'СПОРТ','Азаренко вышла во второй круг Australian Open','Белорусская теннисистка Виктория Азаренко вышла во второй круг открытого чемпионата Австралии - первого из четырех в сезоне турниров Большого шлема','Василий Федосенко','TUT.BY','2015-01-20','Минувшей ночью по белорусскому времени в стартовом матче Азаренко победила 21-летнюю американку Слоан Стивенс (№32) - 6:3, 6:2. Поединок продолжался 1 час 15 минут.\r\nПо ходу встречи Азаренко лишь однажды позволила Стивенс захватить лидерство в счете - американка выиграла самый первый гейм, причем под ноль. Но затем инициатива принадлежала белоруске, которая полностью переиграла оппонентку у сетки, гораздо эффективнее распоряжалась первой подачей и была надежнее на приеме. \r\nВо втором круге (1/32 финала) соперницей Азаренко будет датчанка Каролин Возняцки (№8), которая взяла верх над американкой Тэйлор Таунсенд (№99) - 7:6 (7:1), 6:2.\r\nЭто была уже третья встреча соперниц и третья победа белоруски. Прежде Азаренко побеждала Слоан Стивенс в полуфинале открытого чемпионата Австралии-2013 и в четвертом круге этого турнира в 2014 году. Правда, тогда в рейтинге выше находилась белоруска.\r\nВиктория Азаренко дважды становилась победительницей Australian Open (2012 и 2013), а в прошлом году не сумела защитить титул, проиграв польке Агнешке Радваньской в четвертьфинале.'),(10,'СПОРТ','Домрачева одержала уверенную победу в масс-старте','Дарья Домрачева завершила этап Кубка мира в немецком Рупольдинге уверенной победой в масс-старте','Станислав Коршунов','Reuters','2015-01-18','После первой стрельбы Домрачева занимала лишь 19-е место, но постепенно начала отыгрывать позиции и после второго огневого рубежа занимала уже 7-е место. Высокая скорость позволила белоруске к третьей стрельбе выйти в лидеры, но два штрафных круга откинули трехкратную олимпийскую чемпионку на 11-ю позицию. Впрочем, даже эти неудачи не стали для Домрачевой помехой. Уже к середине предпоследнего круга она возглавила гонку, а идеальная работа на последней стойке только укрепила ее лидерство.');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` tinyint(3) unsigned NOT NULL,
  `name` varchar(20) NOT NULL,
  `fam` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'Сергей','Буглак','bsv@gmail.com','123'),(2,2,'Иван','Колесник','kin@gmail.com','456'),(3,2,'Геннадий','Викторович','hgv@gmail.com','789');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-23 21:42:05
