package br.com.baratasearch.baratasearchservice.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.baratasearch.baratasearchservice.util.ScrapingUtil;

public class Aeroportos {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapingUtil.class);
	
    public static final Map<String, String> AEROPORTOS = new HashMap<>();

    //lista obtida no site https://www.trilhaseaventuras.com.br/siglas-dos-principais-aeroportos-do-mundo-iata/amp/
    static {
    	//Aeroportos de sigla A
        AEROPORTOS.put("AAR", "Aarhus, Denmark – Tirstrup");
        AEROPORTOS.put("ABJ", "Abidjan, Cote D'Ivoire – Port Bouet");
        AEROPORTOS.put("ABQ", "Albuquerque, NM, USA – Albuquerque Intl");
        AEROPORTOS.put("ABR", "Aberdeen, SD, USA – Aberdeen Regional Airport");
        AEROPORTOS.put("ABS", "Abu Simbel, Egypt – Abu Simbel");
        AEROPORTOS.put("ABY", "Albany, GA, USA – Dougherty County");
        AEROPORTOS.put("ABZ", "Aberdeen, Scotland, United Kingdom – Dyce");
        AEROPORTOS.put("ACA", "Acapulco, Guerrero, Mexico – Alvarez International");
        AEROPORTOS.put("ACC", "Accra, Ghana – Kotoka");
        AEROPORTOS.put("ACE", "Lanzarote, Canary Islands, Spain – Lanzarote");
        AEROPORTOS.put("ACY", "Atlantic City /Atlantic Cty, NJ, USA – Atlantic City Intl");
        AEROPORTOS.put("ADA", "Adana, Turkey – Adana");
        AEROPORTOS.put("ADB", "Izmir, Turkey – Adnam Menderes");
        AEROPORTOS.put("ADD", "Addis Ababa, Ethiopia – Bole");
        AEROPORTOS.put("ADJ", "Amman, Jordan – Civil");
        AEROPORTOS.put("ADL", "Adelaide, South Australia, Australia – Adelaide");
        AEROPORTOS.put("ADZ", "San Andres Island, Colombia");
        AEROPORTOS.put("AEP", "Buenos Aires, Argentina – Jorge Newberry");
        AEROPORTOS.put("AEY", "Akureyri, Iceland – Akureyri");
        AEROPORTOS.put("AGA", "Agadir, Morocco – Inezgane");
        AEROPORTOS.put("AGB", "Augsburg, Germany – Muehlhausen");
        AEROPORTOS.put("AGP", "Malaga, Spain – Malaga");
        AEROPORTOS.put("AGR", "Agra, India – Kheria");
        AEROPORTOS.put("AHO", "Alghero, Sardenha, Itália");
        AEROPORTOS.put("AJU", "Aracaju, Sergipe, SE, Brasil");
        AEROPORTOS.put("AKL", "Auckland, New Zealand – Auckland Intl Airport");
        AEROPORTOS.put("ALA", "Almaty, Kazakhstan – Almaty");
        AEROPORTOS.put("ALG", "Algiers, Algeria – Houari Boumedienne");
        AEROPORTOS.put("ALY", "Alexandria, Egypt – Alexandria");
        AEROPORTOS.put("AMM", "Amman, Jordan – Queen Alia International");
        AEROPORTOS.put("AMS", "Amsterdam, Netherlands – Schiphol");
        AEROPORTOS.put("ANC", "Anchorage, AK, USA – Anchorage International");
        AEROPORTOS.put("ANF", "Antofagasta, Chile – Cerro Moreno");
        AEROPORTOS.put("ANU", "Saint Johns / Antigua & Barbuda – Vc Bird Intl");
        AEROPORTOS.put("APW", "Apia, Samoa – Faleolo");
        AEROPORTOS.put("AQP", "Arequipa, Peru – Rodriguez Ballon");
        AEROPORTOS.put("ARI", "Arica, Chile – Chacalluta");
        AEROPORTOS.put("ARN", "Stockholm, Sweden – Arlanda International");
        AEROPORTOS.put("ASD", "Andros Town, Bahamas");
        AEROPORTOS.put("ASE", "Aspen, CO, USA – Pitkin County Airport Sardy Field");
        AEROPORTOS.put("ASU", "Asuncion, Paraguay – Silvio Pettirossi");
        AEROPORTOS.put("ATH", "Athens, Greece – Hellinikon");
        AEROPORTOS.put("ATL", "Atlanta, GA, USA – Hartsfield International");
        AEROPORTOS.put("AUA", "Aruba, Aruba – Reina Beatrix");
        AEROPORTOS.put("AUH", "Abu Dhabi, United Arab Emirates – Abu Dhabi Intl");
        AEROPORTOS.put("AUS", "Austin, TX, USA – Robert Mueller Municipal Airport");
        AEROPORTOS.put("AXA", "Anguilla, Anguilla");
        AEROPORTOS.put("AYT", "Antalya, Turkey – Antalya");
        AEROPORTOS.put("AZO", "Kalamazoo, MI, USA – Kalamazoo/Battle Creek Intl");

        //Aeroportos de sigla B
        AEROPORTOS.put("BAH", "Bahrain, Bahrain – Bahrain Intl");
        AEROPORTOS.put("BAK", "Baku, Azerbaijan – Baku");
        AEROPORTOS.put("BAQ", "Barranquilla, Colombia – E Cortissoz");
        AEROPORTOS.put("BAU", "Bauru, São Paulo, SP, Brasil – Aeroclube Estadual");
        AEROPORTOS.put("BBU", "Bucharest, Romania – Baneasa");
        AEROPORTOS.put("BCN", "Barcelona, Spain – Barcelona");
        AEROPORTOS.put("BDL", "Hartford, CT, USA – Bradley Intl Airport");
        AEROPORTOS.put("BEG", "Belgrade, Yugoslavia – Belgrade");
        AEROPORTOS.put("BEL", "Belem, Para, PA, Brasil – Val De Cans");
        AEROPORTOS.put("BEO", "Newcastle, NSW, Australia – Belmont");
        AEROPORTOS.put("BER", "Berlin, Germany – Schoenefeld");
        AEROPORTOS.put("BEY", "Beirut, Lebanon – International");
        AEROPORTOS.put("BFS", "Belfast, Ireland, United Kingdom – Belfast Intl");
        AEROPORTOS.put("BGF", "Bangui, Central African Republic – Bangui");
        AEROPORTOS.put("BGI", "Bridgetown, Barbados – Grantley Adams Intl");
        AEROPORTOS.put("BGO", "Bergen, Norway – Flesland");
        AEROPORTOS.put("BGR", "Bangor, ME, USA – Bangor Intl Airport");
        AEROPORTOS.put("BGY", "Milan, Italy – Orio Al Serio");
        AEROPORTOS.put("BHD", "Belfast, Northern Ireland, UK – Belfast Harbor");
        AEROPORTOS.put("BHI", "Bahia Blanca, Argentina");
        AEROPORTOS.put("BHX", "Birmingham, England, UK – Intl");
        AEROPORTOS.put("BIA", "Bastia, Corsica, France – Poretta");
        AEROPORTOS.put("BIK", "Biak, Indonesia – Mokmer");
        AEROPORTOS.put("BIM", "Bimini, Bahamas – Bimini Island Intl");
        AEROPORTOS.put("BIO", "Bilbao, Spain – Sondica");
        AEROPORTOS.put("BJL", "Banjul, Gambia – Yundum International");
        AEROPORTOS.put("BJX", "Leon/Guanajuato, Mexico – Del Bajio");
        AEROPORTOS.put("BKI", "Kota Kinabalu, Sabah, Malaysia – Kota Kinabalu");
        AEROPORTOS.put("BKK", "Bangkok, Thailand – Bangkok Intl Airport");
        AEROPORTOS.put("BKO", "Bamako, Mali – Senou");
        AEROPORTOS.put("BLL", "Billund, Denmark – Billund");
        AEROPORTOS.put("BLQ", "Bologna, Italy – Guglielmo Marconi");
        AEROPORTOS.put("BLR", "Bangalore, India – Hindustan");
        AEROPORTOS.put("BLZ", "Blantyre, Malawi – Chileka");
        AEROPORTOS.put("BMA", "Stockholm, Sweden – Bromma Arpt");
        AEROPORTOS.put("BNA", "Nashville, TN, USA – Nashville Metropolitan");
        AEROPORTOS.put("BNE", "Brisbane, Queensland, Australia – Intl");
        AEROPORTOS.put("BOG", "Bogota, Colombia – Eldorado");
        AEROPORTOS.put("BOM", "Bombay, India – Bombay");
        AEROPORTOS.put("BON", "Bonaire, Netherlands Antilles – Flamingo Field");
        AEROPORTOS.put("BOS", "Boston, MA, USA – Logan International Airport");
        AEROPORTOS.put("BPS", "Porto Seguro, Bahia, BA, Brasil");
        AEROPORTOS.put("BRC", "San Carlos De Bariloche, Argentina – Intl");
        AEROPORTOS.put("BRE", "Bremen, Germany – Bremen");
        AEROPORTOS.put("BRI", "Bari Palese, Puglia, Italia – Karol Wojtila");
        AEROPORTOS.put("BRS", "Bristol, England, UK");
        AEROPORTOS.put("BRU", "Brussels, Belgium – National");
        AEROPORTOS.put("BSB", "Brasilia, Distrito Federal, DF, Brasil – Intl");
        AEROPORTOS.put("BUD", "Budapest, Hungary – Ferihegy");
        AEROPORTOS.put("BUQ", "Bulawayo, Zimbabwe – Bulawayo");
        AEROPORTOS.put("BUR", "Burbank, CA, USA – Burbank Glendale Pasadena");
        AEROPORTOS.put("BVA", "Boa Vista, Cape Verde – Boa Vista");
        AEROPORTOS.put("BVB", "Boa Vista, Roraima, RR, Brasil");
        AEROPORTOS.put("BWI", "Baltimore, MD, USA – Baltimore-Washington Intl");
        AEROPORTOS.put("BWN", "Bandar Seri Begawan, Brunei – Intl");
        AEROPORTOS.put("BZE", "Belize City, Belize – Belize International");
        
        //Aeroportos de sigla C
        AEROPORTOS.put("CAG", "Cagliari, Sardenha, Itália");
        AEROPORTOS.put("CAI", "Cairo, Egypt – International");
        AEROPORTOS.put("CAN", "Guangzhou, China – Baiyun");
        AEROPORTOS.put("CAS", "Casablanca, Morocco – Anfa");
        AEROPORTOS.put("CAU", "Caruarú, Pernambuco, PE, Brasil – Oscar Laranjeiras");
        AEROPORTOS.put("CAY", "Cayenne, French Guiana – Rochambeau");
        AEROPORTOS.put("CBB", "Cochabamba, Bolivia – S. J. De La Banda");
        AEROPORTOS.put("CBR", "Canberra, Australia");
        AEROPORTOS.put("CCM", "Criciúma, Santa Catarina, SC, Brasil");
        AEROPORTOS.put("CCP", "Concepcion, Chile – Carriel Sur");
        AEROPORTOS.put("CCS", "Caracas, Venezuela – Simon Bolivar Intl");
        AEROPORTOS.put("CCU", "Calcutta, India – Calcutta");
        AEROPORTOS.put("CDG", "Paris, France – Charles De Gaulle");
        AEROPORTOS.put("CEB", "Cebu, Philippines – International");
        AEROPORTOS.put("CGB", "Cuiabá, Mato Grosso, MT, Brasil");
        AEROPORTOS.put("CGH", "São Paulo, SP, Brasil – Congonhas");
        AEROPORTOS.put("CGK", "Jakarta, Indonesia – Soekarno Hatta Intl");
        AEROPORTOS.put("CGN", "Cologne/Bonn, Germany – Köln/Bonn");
        AEROPORTOS.put("CGR", "Campo Grande, Mato Grosso do Sul, MS, Brasil");
        AEROPORTOS.put("CHC", "Christchurch, New Zealand – Intl");
        AEROPORTOS.put("CHM", "Chimbote, Peru");
        AEROPORTOS.put("CHS", "Charleston, SC, USA – Charleston Il");
        AEROPORTOS.put("CIA", "Rome, Italy – Ciampino");
        AEROPORTOS.put("CJU", "Cheju, South Korea – Cheju");
        AEROPORTOS.put("CKS", "Carajás, Pará, PA, Brasil");
        AEROPORTOS.put("CKY", "Conakry, Guinea – Conakry");
        AEROPORTOS.put("CLE", "Cleveland, OH, USA – Hopkins Intl");
        AEROPORTOS.put("CLO", "Cali, Colombia – Alfonso Bonilla Aragon");
        AEROPORTOS.put("CLT", "Charlotte, NC, USA – Charlotte/Douglas Intl");
        AEROPORTOS.put("CMB", "Colombo, Sri Lanka – Katunayake Intl");
        AEROPORTOS.put("CMG", "Corumbá, Mato Grosso do Sul, MS, Brasil");
        AEROPORTOS.put("CMH", "Columbus, OH, USA – Port Columbus Intl");
        AEROPORTOS.put("CMN", "Casablanca, Morocco – Mohamed V");
        AEROPORTOS.put("CNF", "Belo Horizonte, Minas Gerais, BH, Brasil – Tancredo Neves");
        AEROPORTOS.put("CNS", "Cairns, Queensland, Australia");
        AEROPORTOS.put("CNX", "Chiang Mai, Thailand – Intl");
        AEROPORTOS.put("COR", "Cordoba, Argentina – Pajas Blancas");
        AEROPORTOS.put("COS", "Colorado Springs, CO, USA -Municipal");
        AEROPORTOS.put("CPC", "San Martin De Los Andes, Neuquen, Argentina");
        AEROPORTOS.put("CPH", "Copenhagen, Denmark");
        AEROPORTOS.put("CPT", "Cape Town, South Africa – D F Malan");
        AEROPORTOS.put("CPV", "Campina Grande, Paraíba, PB, Brasil");
        AEROPORTOS.put("CRD", "Comodoro Rivadavia, Chubut, Argentina");
        AEROPORTOS.put("CRU", "Carriacou Island, Grenada");
        AEROPORTOS.put("CTG", "Cartagena, Colombia – Rafael Nunez");
        AEROPORTOS.put("CTS", "Sapporo, Japan – Chitose");
        AEROPORTOS.put("CTU", "Chengdu, China");
        AEROPORTOS.put("CUC", "Cucuta, Colombia – Camilo Daza");
        AEROPORTOS.put("CUE", "Cuenca, Ecuador – Mariscal La Mar");
        AEROPORTOS.put("CUN", "Cancun, Mexico");
        AEROPORTOS.put("CUR", "Willemstad / Curacao – Hato");
        AEROPORTOS.put("CUU", "Chihuahua, Mexico – Gen. Villalobos");
        AEROPORTOS.put("CUZ", "Cuzco, Peru – Tte Velazco Astete");
        AEROPORTOS.put("CVG", "Cincinnati, OH, USA – Greater Cincinnati Intl");
        AEROPORTOS.put("CWB", "Curitiba, Paraná, PR, Brasil – Afonso Pena");
        AEROPORTOS.put("CWL", "Cardiff, Wales, United Kingdom");
        AEROPORTOS.put("CYB", "Cayman Brac Island, Cayman Islands");
        AEROPORTOS.put("CYR", "Colonia, Uruguay");
        AEROPORTOS.put("CZM", "Cozumel, Quintana Roo, México");
        AEROPORTOS.put("CZS", "Cruzeiro do Sul, Acre, AC, Brasil");
        
        //Aeroportos de sigla D
        AEROPORTOS.put("DAB", "Daytona Beach, FL, USA");
        AEROPORTOS.put("DAC", "Dhaka, Bangladesh – Zia Inl");
        AEROPORTOS.put("DAD", "Da Nang, Vietnam – Da Nang");
        AEROPORTOS.put("DAL", "Dallas, TX, USA – Love Field");
        AEROPORTOS.put("DAM", "Damascus, Syria – Damascus Intl");
        AEROPORTOS.put("DAR", "Dar Es Salaam, Tanzania – Intl");
        AEROPORTOS.put("DAY", "Dayton, OH, USA – James M Cox Intel");
        AEROPORTOS.put("DBV", "Dubrovnik, Croatia – Hrvatska");
        AEROPORTOS.put("DCA", "Washington, DC, USA – Reagan / National");
        AEROPORTOS.put("DEL", "Delhi, India – Delhi Intl");
        AEROPORTOS.put("DEN", "Denver, CO, USA – Denver Intl");
        AEROPORTOS.put("DFW", "Dallas/Ft Worth, TX, USA – DFW Intl");
        AEROPORTOS.put("DHA", "Dhahran, Saudi Arabia – Intl");
        AEROPORTOS.put("DIJ", "Dijon, France – Longvic");
        AEROPORTOS.put("DIL", "Dili, Indonesia – Comoro");
        AEROPORTOS.put("DKR", "Dakar, Senegal – Yoff");
        AEROPORTOS.put("DLA", "Douala, Cameroon");
        AEROPORTOS.put("DLC", "Dalian, China");
        AEROPORTOS.put("DME", "Moscou, Russia – Domodedovo");
        AEROPORTOS.put("DOH", "Doha, Qatar – Doha");
        AEROPORTOS.put("DOM", "Dominica, Dominica – Melville Hal-Dom");
        AEROPORTOS.put("DPS", "Denpasar Bali, Indonesia – Ngurah Rai");
        AEROPORTOS.put("DRS", "Dresden, Germany – Dresden");
        AEROPORTOS.put("DSM", "Des Moines, IA, USA");
        AEROPORTOS.put("DTM", "Dortmund, Germany – Wickede");
        AEROPORTOS.put("DTW", "Detroit, MI, USA – Metropolitan");
        AEROPORTOS.put("DUB", "Dublin, Ireland – Dublin");
        AEROPORTOS.put("DUR", "Durban, South Africa – Louis Botha");
        AEROPORTOS.put("DUS", "Dusseldorf, Germany – Dusseldorf");
        AEROPORTOS.put("DUT", "Dutch Harbor, AK, USA");
        AEROPORTOS.put("DVO", "Davao, Philippines – Mati");
        AEROPORTOS.put("DXB", "Dubai, United Arab Emirates – Intl");

        //Aeroportos de sigla E        
        AEROPORTOS.put("EBB", "Entebbe/Kampala, Uganda");
        AEROPORTOS.put("EDI", "Edinburgh, Scotland, UK – Turnhouse");
        AEROPORTOS.put("EIN", "Eindhoven, Netherlands – Welschap");
        AEROPORTOS.put("EIS", "Tortola/Beef Island, UK Virgin Islands");
        AEROPORTOS.put("ELH", "North Eleuthera, Bahamas");
        AEROPORTOS.put("ELP", "El Paso, TX, USA – El Paso Intl");
        AEROPORTOS.put("EMA", "East Midlands, UK");
        AEROPORTOS.put("EOH", "Medellin, Colombia – Enrique Olaya Herrara");
        AEROPORTOS.put("ERS", "Windhoek, Namibia – Eros");
        AEROPORTOS.put("ESB", "Ankara, Turkey – Esenboga");
        AEROPORTOS.put("ETH", "Elat, Israel");
        AEROPORTOS.put("ETZ", "Metz/Nancy, France – Frescaty");
        AEROPORTOS.put("EVN", "Yerevan, Armenia");
        AEROPORTOS.put("EWR", "Newark, NJ, USA – International");
        AEROPORTOS.put("EXT", "Exeter, England, UK");
        AEROPORTOS.put("EYW", "Key West, FL, USA");
        AEROPORTOS.put("EZE", "Buenos Aires, Argentina Min. Pistarini");

        //Aeroportos de sigla F
        AEROPORTOS.put("FAE", "Faroe Islands,");
        AEROPORTOS.put("FAI", "Fairbanks, AK, USA – International");
        AEROPORTOS.put("FAO", "Faro, Portugal");
        AEROPORTOS.put("FAR", "Fargo, ND, USA – Hector");
        AEROPORTOS.put("FAT", "Fresno, CA, USA");
        AEROPORTOS.put("FBU", "Oslo, Norway – Fornebu");
        AEROPORTOS.put("FCO", "Rome, Italy – Leonardo Da Vinci/Fiumicino");
        AEROPORTOS.put("FDF", "Fort De France, Martinique");
        AEROPORTOS.put("FDO", "San Fernando, Argentina");
        AEROPORTOS.put("FEZ", "Fez, Morocco");
        AEROPORTOS.put("FIH", "Kinshasa, Zaire – Kinshasa");
        AEROPORTOS.put("FLL", "Ft Lauderdale, FL, USA – F. Laud. Hollywood Intl");
        AEROPORTOS.put("FLN", "Florianópolis, Santa Catarina, SC, Brasil");
        AEROPORTOS.put("FLR", "Florença, Italia");
        AEROPORTOS.put("FMO", "Münster, Germany");
        AEROPORTOS.put("FNC", "Funchal, Madeira, Portugal");
        AEROPORTOS.put("FOR", "Fortaleza, Ceará, CE, Brasil");
        AEROPORTOS.put("FPO", "Freeport, Bahamas – Intl");
        AEROPORTOS.put("FRA", "Frankfurt, Germany – International");
        AEROPORTOS.put("FUK", "Fukuoka, Japan – Itazuke");
    
        //Aeroportos de sigla G
        AEROPORTOS.put("GAJ", "Yamagata, Japan – Junmachi");
        AEROPORTOS.put("GBE", "Gaborone, Botswana");
        AEROPORTOS.put("GCI", "Guernsey, Channel Islands, UK");
        AEROPORTOS.put("GCM", "Grand Cayman - Owen Roberts");
        AEROPORTOS.put("GCN", "Grand Canyon, AZ, USA");
        AEROPORTOS.put("GDL", "Guadalajara, Mexico – Miguel Hidalgo Intl");
        AEROPORTOS.put("GDN", "Gdansk, Poland – Rebiechowo");
        AEROPORTOS.put("GDT", "Grand Turk Is, Turks & Caicos");
        AEROPORTOS.put("GDX", "Magadan, Russia");
        AEROPORTOS.put("GEN", "Oslo, Norway – Gardermoen");
        AEROPORTOS.put("GEO", "Georgetown, Guyana – Timehri");
        AEROPORTOS.put("GGT", "George Town, Bahamas – Exuma");
        AEROPORTOS.put("GHB", "Governors Harbour, Bahamas");
        AEROPORTOS.put("GIB", "Gibraltar");
        AEROPORTOS.put("GIG", "Galeão, Rio de Janeiro, RJ, Brasil – Tom Jobim Intl");
        AEROPORTOS.put("GLA", "Glasgow, Scotland, UK");
        AEROPORTOS.put("GNB", "Grenoble, France – St Geoirs");
        AEROPORTOS.put("GND", "St Georges/Grenada – Pt Saline");
        AEROPORTOS.put("GOA", "Genoa, Italy – Christoforo Colombo");
        AEROPORTOS.put("GOT", "Gothenburg, Sweden – Landvetter");
        AEROPORTOS.put("GPS", "Galapagos Islands, Ecuador – Baltra");
        AEROPORTOS.put("GRO", "Gerona, Spain – Costa Brava");
        AEROPORTOS.put("GRQ", "Groningen, Netherlands – Eelde");
        AEROPORTOS.put("GRU", "São Paulo, SP, Brasil – Guarulhos / F. Montoro");
        AEROPORTOS.put("GRX", "Granada, Spain");
        AEROPORTOS.put("GRZ", "Graz, Austria – Thalerhof");
        AEROPORTOS.put("GUA", "Guatemala City, Guatemala – La Aurora");
        AEROPORTOS.put("GUM", "Guam – Ab Wonpat Intl");
        AEROPORTOS.put("GUZ", "Guarapari, Espírito Santo, ES, Brasil");
        AEROPORTOS.put("GVA", "Geneva, Switzerland");
        AEROPORTOS.put("GXQ", "Coyhaique, Chile – Teniente Vidal");
        AEROPORTOS.put("GYE", "Guayaquil, Ecuador – Simon Bolívar");
        AEROPORTOS.put("GYN", "Goiânia, GO, Brasil – Santa Genoveva");
        
        //Aeroportos de sigla H
        AEROPORTOS.put("HAG", "The Hague, Netherlands");
        AEROPORTOS.put("HAH", "Moroni (Hahaya), Comoros");
        AEROPORTOS.put("HAJ", "Hanover, Germany – Langenhagen");
        AEROPORTOS.put("HAK", "Haikou, China – Haikou");
        AEROPORTOS.put("HAM", "Hamburg, Germany – Fuhlsbuttel");
        AEROPORTOS.put("HAN", "Hanoi, Vietnam – Noibai Airport");
        AEROPORTOS.put("HAV", "Havana, Cuba – Jose Marti");
        AEROPORTOS.put("HBA", "Hobart, Tasmania, Australia");
        AEROPORTOS.put("HDB", "Heidelberg, Germany");
        AEROPORTOS.put("HEL", "Helsinki, Finland – Helsinki");
        AEROPORTOS.put("HER", "Heraklion, Crete Island, Greece");
        AEROPORTOS.put("HIJ", "Hiroshima, Japan");
        AEROPORTOS.put("HIR", "Honiara/Guadalcanal, Solomon");
        AEROPORTOS.put("HIS", "Hayman Island, Australia");
        AEROPORTOS.put("HKD", "Hakodate, Japan");
        AEROPORTOS.put("HKG", "Hong Kong, Hong Kong");
        AEROPORTOS.put("HKT", "Phuket, Thailand – Phuket");
        AEROPORTOS.put("HMA", "Malmo, Sweden");
        AEROPORTOS.put("HNL", "Honolulu, HI, USA – International");
        AEROPORTOS.put("HOU", "Houston, TX, USA – Hobby");
        AEROPORTOS.put("HPV", "Kauai Island, HI, USA – Princeville");
        AEROPORTOS.put("HRB", "Harbin, China");
        AEROPORTOS.put("HRE", "Harare, Zimbabwe");
        AEROPORTOS.put("HRG", "Hurghada, Egypt");
        AEROPORTOS.put("HRK", "Kharkov, Ukraine");
        AEROPORTOS.put("HUN", "Hualien, Taiwan");
        AEROPORTOS.put("HUX", "Huatulco, Oaxaca, Mexico");
        AEROPORTOS.put("HYD", "Hyderabad, India – Begumpet");
        
        //Aeroportos de sigla I
        AEROPORTOS.put("IAD", "Washington, DC, USA – Dulles");
        AEROPORTOS.put("IAH", "Houston, TX, USA – Intercontinental");
        AEROPORTOS.put("IBZ", "Ibiza, Spain – Ibiza");
        AEROPORTOS.put("IEV", "Kiev, Ukraine – Zhulhany");
        AEROPORTOS.put("IGM", "Kingman, AZ, USA – Mohave County");
        AEROPORTOS.put("IGR", "Iguazu, Argentina – International");
        AEROPORTOS.put("IGU", "Foz do Iguaçu, Paraná, PR, Brasil – Cataratas");
        AEROPORTOS.put("IKT", "Irkutsk, Russia");
        AEROPORTOS.put("IMP", "Imperatriz, Maranhão, MA, Brasil");
        AEROPORTOS.put("INN", "Innsbruck, Austria – Kranebitten");
        AEROPORTOS.put("INU", "Nauru, Nauru");
        AEROPORTOS.put("INV", "Inverness, Scotland, UK");
        AEROPORTOS.put("IOM", "Isle Of Man, UK – Ronaldsway");
        AEROPORTOS.put("IOS", "Ilhéus, Bahia, BA, Brasil");
        AEROPORTOS.put("IPC", "Ilha da Páscoa, Chile – Mataveri");
        AEROPORTOS.put("IPH", "Ipoh, Malaysia – Ipoh");
        AEROPORTOS.put("IPI", "Ipiales, Colombia – San Luis");
        AEROPORTOS.put("IQQ", "Iquique, Chile – Chucumata");
        AEROPORTOS.put("IQT", "Iquitos, Peru – Cf Secada");
        AEROPORTOS.put("ISB", "Islamabad, Pakistan – International");
        AEROPORTOS.put("ISC", "Isles Of Scilly, UK – Tresco");
        AEROPORTOS.put("IST", "Istanbul, Turkey – Ataturk");
        AEROPORTOS.put("ITM", "Osaka, Japan – Itami International");
        AEROPORTOS.put("ITO", "Hilo, HI, USA – Hilo Hawaii");
        AEROPORTOS.put("IZO", "Izumo, Japan");
        
        //Aeroportos de sigla J
        AEROPORTOS.put("JAI", "Jaipur, India – Sanganeer");
        AEROPORTOS.put("JAX", "Jacksonville, FL, USA – International");
        AEROPORTOS.put("JDF", "Juíz de Fora, Minas Gerais, MG, Brasil");
        AEROPORTOS.put("JDH", "Jodhpur, India");
        AEROPORTOS.put("JDO", "Juazeiro do Norte, Ceará, CE, Brasil – Orlando Bezerra de Menezes");
        AEROPORTOS.put("JED", "Jeddah, Saudi Arabia – International");
        AEROPORTOS.put("JER", "Jersey, Channel Islands, UK – States");
        AEROPORTOS.put("JFK", "New York, USA – John F Kennedy Intl");
        AEROPORTOS.put("JIB", "Djibouti, Djibouti – Ambouli");
        AEROPORTOS.put("JKG", "Jonkoping, Sweden – Axamo");
        AEROPORTOS.put("JMK", "Mikonos, Greece – Mikonos");
        AEROPORTOS.put("JNB", "Johannesburg, South Africa – Jan Smuts");
        AEROPORTOS.put("JNX", "Naxos, Greece");
        AEROPORTOS.put("JOG", "Yogyakarta, Indonesia");
        AEROPORTOS.put("JOI", "Joinville, Santa Catarina, SC, Brasil");
        AEROPORTOS.put("JON", "Johnston Island, US, Outlying Islands");
        AEROPORTOS.put("JRO", "Kilimanjaro, Tanzania");
        AEROPORTOS.put("JTC", "Bauru-Arealva, São Paulo, SP, Brasil");
        AEROPORTOS.put("JTR", "Santorini, Greece");
        AEROPORTOS.put("JUJ", "Jujuy, Argentina – El Cadillal");
        AEROPORTOS.put("JUL", "Juliaca, Peru – Juliaca");
        
        //Aeroportos de sigla K
        AEROPORTOS.put("KAN", "Kano, Nigeria – Aminu Kano");
        AEROPORTOS.put("KBP", "Kiev, Ukraine – Borispol");
        AEROPORTOS.put("KEF", "Reykjavik, Iceland – Intl");
        AEROPORTOS.put("KEL", "Kiel, Germany – Holtenau");
        AEROPORTOS.put("KGD", "Kaliningrad, Russia");
        AEROPORTOS.put("KHI", "Karachi, Pakistan");
        AEROPORTOS.put("KIN", "Kingston, Jamaica");
        AEROPORTOS.put("KIX", "Osaka, Japan – Kansai Intl");
        AEROPORTOS.put("KJA", "Krasnojarsk, Russia");
        AEROPORTOS.put("KLU", "Klagenfurt, Austria – Klagenfurt");
        AEROPORTOS.put("KMG", "Kunming, China");
        AEROPORTOS.put("KMI", "Miyazaki, Japan");
        AEROPORTOS.put("KMJ", "Kumamoto, Japan");
        AEROPORTOS.put("KOA", "Kona, HI, USA – Keahole");
        AEROPORTOS.put("KOJ", "Kagoshima, Japan");
        AEROPORTOS.put("KRK", "Krakow, Poland – Balice");
        AEROPORTOS.put("KRN", "Kiruna, Sweden – Kiruna");
        AEROPORTOS.put("KRP", "Karup, Denmark – Karup");
        AEROPORTOS.put("KRT", "Khartoum, Sudan – Civil");
        AEROPORTOS.put("KSA", "Kosrae, Caroline Islands, Micronesia");
        AEROPORTOS.put("KTM", "Kathmandu, Nepal – Tribhuvan");
        AEROPORTOS.put("KTW", "Katowice, Poland – Pyrzowice");
        AEROPORTOS.put("KUL", "Kuala Lumpur, Malaysia – Subang");
        AEROPORTOS.put("KUN", "Kaunas, Lithuania – Kaunas");
        AEROPORTOS.put("KUO", "Kuopio, Finland – Kuopio");
        AEROPORTOS.put("KUV", "Kunsan, South Korea");
        AEROPORTOS.put("KVA", "Kavala, Greece – Kavala");
        AEROPORTOS.put("KWA", "Kwajalein, Marshall Islands");
        AEROPORTOS.put("KWI", "Kuwait, – International");
        AEROPORTOS.put("KWL", "Guilin, China");
        AEROPORTOS.put("KZN", "Kazan, Rússia");
        
        //Aeroportos de sigla L
        AEROPORTOS.put("LAD", "Luanda, Angola");
        AEROPORTOS.put("LAS", "Las Vegas, NV, USA – McCarran");
        AEROPORTOS.put("LAX", "Los Angeles, CA, USA – International");
        AEROPORTOS.put("LBA", "Leeds/Bradford, England, UK");
        AEROPORTOS.put("LBV", "Libreville, Gabon –");
        AEROPORTOS.put("LCA", "Larnaca, Cyprus – Intl");
        AEROPORTOS.put("LCE", "La Ceiba, Honduras – International");
        AEROPORTOS.put("LCG", "La Coruna, Spain");
        AEROPORTOS.put("LCY", "London, England, UK – London City");
        AEROPORTOS.put("LDB", "Londrina, Paraná, PR, Brasil");
        AEROPORTOS.put("LDE", "Lourdes/Tarbes, France –");
        AEROPORTOS.put("LEJ", "Leipzig, Germany");
        AEROPORTOS.put("LET", "Leticia, Colombia – Gen Av Cobu");
        AEROPORTOS.put("LFW", "Lome, Togo");
        AEROPORTOS.put("LGA", "New York, NY, USA – La Guardia");
        AEROPORTOS.put("LGB", "Long Beach, CA, USA – Municipal");
        AEROPORTOS.put("LGK", "Langkawi, Malaysia");
        AEROPORTOS.put("LGW", "London, England, UK – Gatwick");
        AEROPORTOS.put("LHE", "Lahore, Pakistan – Lahore");
        AEROPORTOS.put("LHR", "London, England, UK – Heathrow");
        AEROPORTOS.put("LIM", "Lima, Peru – Jorge Chavez");
        AEROPORTOS.put("LIN", "Milan, Italy – Linate");
        AEROPORTOS.put("LIS", "Lisboa, Portugal – Portela de Sacavém");
        AEROPORTOS.put("LJU", "Ljubljana, Slovenia – Brnik");
        AEROPORTOS.put("LLW", "Lilongwe, Malawi – Kamuzu Intl");
        AEROPORTOS.put("LNZ", "Linz, Austria");
        AEROPORTOS.put("LOS", "Lagos, Nigeria – Murtala Muhammed");
        AEROPORTOS.put("LPB", "La Paz, Bolivia – El Alto");
        AEROPORTOS.put("LPI", "Linkoping, Sweden – Saab");
        AEROPORTOS.put("LPL", "Liverpool, England, UK");
        AEROPORTOS.put("LRM", "Casa De Campo, Dominican Republic");
        AEROPORTOS.put("LSS", "Terre-De-Haut, Guadeloupe");
        AEROPORTOS.put("LTN", "London, England, UK – Luton");
        AEROPORTOS.put("LUG", "Lugano, Switzerland – Agno");
        AEROPORTOS.put("LUN", "Lusaka, Zambia");
        AEROPORTOS.put("LUX", "Luxembourg – Findel");
        AEROPORTOS.put("LVI", "Livingstone, Zambia");
        AEROPORTOS.put("LWO", "Lvov, Ukraine – Snilow");
        AEROPORTOS.put("LWY", "Lawas, Sarawak, Malaysia");
        AEROPORTOS.put("LXR", "Luxor, Egypt");
        AEROPORTOS.put("LYS", "Lyon, France – Satolas");
        
		//Aeroportos de sigla M
        AEROPORTOS.put("MAA", "Madras, India – Meenambarkkam");
        AEROPORTOS.put("MAD", "Madrid, Spain – Barajas");
        AEROPORTOS.put("MAH", "Menorca, Spain");
        AEROPORTOS.put("MAJ", "Majuro, Marshall Islands – International");
        AEROPORTOS.put("MAN", "Manchester, England, UK");
        AEROPORTOS.put("MAO", "Manaus, Amazonas, AM, Brasil – Eduardo Gomes");
        AEROPORTOS.put("MAR", "Maracaibo, Venezuela – La Chinita");
        AEROPORTOS.put("MBA", "Mombasa, Kenya – Moi International");
        AEROPORTOS.put("MBJ", "Montego Bay, Jamaica – Sangster");
        AEROPORTOS.put("MCI", "Kansas City, MO, USA – International");
        AEROPORTOS.put("MCM", "Monte Carlo, Monaco – Heliporto");
        AEROPORTOS.put("MCO", "Orlando, FL, USA – International");
        AEROPORTOS.put("MCP", "Macapa, Amapá, AP, Brasil");
        AEROPORTOS.put("MCT", "Muscat, Oman – Seeb");
        AEROPORTOS.put("MCZ", "Maceió, Alagoas, AL, Brasil – Zumbi dos Palmares");
        AEROPORTOS.put("MDC", "Manado, Indonesia – Samratulang");
        AEROPORTOS.put("MDE", "Medellin, Colombia – La Playas");
        AEROPORTOS.put("MDQ", "Mar Del Plata, Argentina");
        AEROPORTOS.put("MDW", "Chicago, IL, USA");
        AEROPORTOS.put("MDZ", "Mendoza, Argentina – El Plumerillo");
        AEROPORTOS.put("MEC", "Manta, Equador");
        AEROPORTOS.put("MED", "Medinah, Saudi Arabia – Prince Mohammad Bin Abdulaziz");
        AEROPORTOS.put("MEL", "Melbourne, Australia – Tullamarine");
        AEROPORTOS.put("MEM", "Memphis, TN, USA -International");
        AEROPORTOS.put("MES", "Medan, Indonesia");
        AEROPORTOS.put("MEX", "Mexico City – Mexico -Benito Juarez");
        AEROPORTOS.put("MGA", "Managua, Nicaragua");
        AEROPORTOS.put("MGQ", "Mogadishu, Somalia");
        AEROPORTOS.put("MIA", "Miami, FL, USA – International");
        AEROPORTOS.put("MLA", "Malta – Luqa");
        AEROPORTOS.put("MLE", "Male, Maldives – Male International");
        AEROPORTOS.put("MLH", "Mulhouse, France");
        AEROPORTOS.put("MMX", "Malmo, Sweden – Sturup");
        AEROPORTOS.put("MNI", "Montserrat – Blackburne");
        AEROPORTOS.put("MNL", "Manila, Philippines – Ninoy Aquino");
        AEROPORTOS.put("MPM", "Maputo, Mozambique – International");
        AEROPORTOS.put("MRS", "Marseille, France – Marseille-Provence");
        AEROPORTOS.put("MRU", "Mauritius, – Plaisance");
        AEROPORTOS.put("MSP", "Minneapolis, MN, USA – MSP Intl");
        AEROPORTOS.put("MSY", "New Orleans, LA, USA – Moisant Intl");
        AEROPORTOS.put("MTY", "Monterrey, Mexico – Escobedo");
        AEROPORTOS.put("MUB", "Maun, Botswana");
        AEROPORTOS.put("MUC", "Munich, Germany – Franz Josef Strauss");
        AEROPORTOS.put("MUN", "Maturin, Venezuela");
        AEROPORTOS.put("MVD", "Montevideo, Uruguay – Carrasco");
        AEROPORTOS.put("MVF", "Mossoró, Rio Grande do Norte, RN, Brasil – Dix-Sept Rosado");
        AEROPORTOS.put("MXP", "Milan, Italy – Malpensa");
        
        //Aeroportos de sigla N
        AEROPORTOS.put("NAN", "Nadi, Fiji – International");
        AEROPORTOS.put("NAP", "Naples, Italy – Capodichino");
        AEROPORTOS.put("NAS", "Nassau, Bahamas – International");
        AEROPORTOS.put("NAT", "Natal, Rio Grande do Norte, RN, Brasil – Augusto Severo");
        AEROPORTOS.put("NBO", "Nairobi, Kenya – Jomo Kenyatta");
        AEROPORTOS.put("NCA", "North Caicos, Turks & Caicos");
        AEROPORTOS.put("NCE", "Nice, France – Cote D`Azur");
        AEROPORTOS.put("NCL", "Newcastle, England, UK");
        AEROPORTOS.put("NCY", "Annecy, France – Annecy-Meythe");
        AEROPORTOS.put("NDJ", "Ndjamena, Chad – N`djamena");
        AEROPORTOS.put("NEV", "Nevis, Saint Kitts And Nevis");
        AEROPORTOS.put("NGO", "Nagoya, Japan – Komaki");
        AEROPORTOS.put("NGS", "Nagasaki, Japan – Nagasaki");
        AEROPORTOS.put("NKC", "Nouakchott, Mauritania");
        AEROPORTOS.put("NKG", "Nanjing, China");
        AEROPORTOS.put("NLA", "Ndola, Zambia");
        AEROPORTOS.put("NLD", "Nuevo Laredo, Tamaulipas, Mexico");
        AEROPORTOS.put("NLP", "Nelspruit, South Africa");
        AEROPORTOS.put("NOU", "Noumea, New Caledonia – Tontouta");
        AEROPORTOS.put("NRT", "Tokyo, Japan – Narita");
        AEROPORTOS.put("NSI", "Yaounde, Cameroon – Nsimalen");
        AEROPORTOS.put("NSN", "Nelson, New Zealand – Nelson");
        AEROPORTOS.put("NTE", "Nantes, France - Chateau Bougon");
        AEROPORTOS.put("NTL", "Newcastle, Australia – Williamtown");
        AEROPORTOS.put("NUE", "Nuremberg, Germany – Nuremberg");
        AEROPORTOS.put("NVT", "Navegantes, Santa Catarina, SC, Brasil");
        
        //Aeroportos de sigla O 
        AEROPORTOS.put("OAK", "Oakland, CA, USA – Metropolitan");
        AEROPORTOS.put("OAX", "Oaxaca, Oaxaca, Mexico – Xoxocotlan");
        AEROPORTOS.put("ODE", "Odense, Denmark");
        AEROPORTOS.put("OKA", "Okinawa, Ryukyu Islands, Japan");
        AEROPORTOS.put("OKC", "Oklahoma City, OK, USA – Will Rogers");
        AEROPORTOS.put("OKJ", "Okayama, Japan");
        AEROPORTOS.put("OLB", "Olbia-Costa Smeralda, Sardenha, Itália");
        AEROPORTOS.put("ONT", "Ontario, CA, USA – International");
        AEROPORTOS.put("OPF", "Miami, FL, USA – Opa Locka");
        AEROPORTOS.put("OPO", "Porto, Portugal");
        AEROPORTOS.put("ORB", "Orebro, Sweden");
        AEROPORTOS.put("ORD", "Chicago, IL, USA – O`Hare");
        AEROPORTOS.put("ORF", "Norfolk, VA, USA");
        AEROPORTOS.put("ORK", "Cork, Ireland");
        AEROPORTOS.put("ORL", "Orlando, FL, USA – Herndon");
        AEROPORTOS.put("ORN", "Oran, Algeria – Es Senia");
        AEROPORTOS.put("ORY", "Paris, France – Orly");
        AEROPORTOS.put("OSH", "Oshkosh, WI, USA – Wittman Field");
        AEROPORTOS.put("OTP", "Bucharest, Romania – Otopeni");
        AEROPORTOS.put("OUA", "Ouagadougou, Burkina Faso");
        AEROPORTOS.put("OUL", "Oulu, Finland – Oulu");
        AEROPORTOS.put("OVB", "Novosibirsk, Russia – Tolmachevo");
        AEROPORTOS.put("OVD", "Asturias, Spain – Asturias");
        AEROPORTOS.put("OXB", "Bissau, Guinea-Bissau – Osvaldo Vieira");
        AEROPORTOS.put("OZZ", "Ouarzazate, Morocco");
        
        //Aeroportos de sigla P
        AEROPORTOS.put("PAD", "Paderborn, Germany");
        AEROPORTOS.put("PAP", "Port Au Prince, Haiti – Mais Gate");
        AEROPORTOS.put("PAT", "Patna, India – Patna");
        AEROPORTOS.put("PAZ", "Poza Rica, Veracruz, Mexico");
        AEROPORTOS.put("PBC", "Puebla, Puebla, Mexico");
        AEROPORTOS.put("PBI", "West Palm Beach, FL, USA");
        AEROPORTOS.put("PBM", "Paramaribo, Suriname – Zanderij");
        AEROPORTOS.put("PDG", "Padang, Indonesia – Tabing");
        AEROPORTOS.put("PDL", "Ponta Delgada, Açores, Portugal – Nordela");
        AEROPORTOS.put("PDX", "Portland, OR, USA – International");
        AEROPORTOS.put("PEK", "Beijing, China – Capital Airport");
        AEROPORTOS.put("PEN", "Penang, Malaysia – International");
        AEROPORTOS.put("PER", "Perth, Australia");
        AEROPORTOS.put("PEW", "Peshawar, Pakistan");
        AEROPORTOS.put("PFO", "Paphos, Cyprus – International");
        AEROPORTOS.put("PHL", "Philadelphia, PA, USA – International");
        AEROPORTOS.put("PHX", "Phoenix, AZ, USA – Sky Harbor");
        AEROPORTOS.put("PID", "Nassau, Bahamas – Paradise Island");
        AEROPORTOS.put("PIK", "Glasgow, Scotland, UK – Prestwick");
        AEROPORTOS.put("PIT", "Pittsburgh, PA, USA – Greater Pit Intl");
        AEROPORTOS.put("PLS", "Providenciales, Turks And Caicos");
        AEROPORTOS.put("PLU", "Belo Horizonte, Minas Gerais, MG, Brasil – Pampulha");
        AEROPORTOS.put("PMC", "Puerto Montt, Chile – Tepual");
        AEROPORTOS.put("PMG", "Ponta Porã, Mato Grosso do Sul, MS, Brasil");
        AEROPORTOS.put("PMI", "Palma Mallorca, Spain");
        AEROPORTOS.put("PMO", "Palermo, Sicily, Italy – Punta Raisi");
        AEROPORTOS.put("PNH", "Phnom Penh, Cambodia – Pochentong");
        AEROPORTOS.put("PNI", "Pohnpei, Caroline Islands, Micronesia");
        AEROPORTOS.put("PNZ", "Petrolina, Pernambuco, PE, Brasil – Senador Nilo Coelho");
        AEROPORTOS.put("POA", "Porto Alegre, Rio Grande do Sul, RS, Brasil – Salgado Filho");
        AEROPORTOS.put("POG", "Port Gentil, Gabon");
        AEROPORTOS.put("POM", "Port Moresby, Papua New Guinea – Jackson");
        AEROPORTOS.put("POP", "Puerto Plata, Dominican Republic – La Union");
        AEROPORTOS.put("POS", "Port Of Spain, Trinidad & Tobago – Piarco");
        AEROPORTOS.put("PPG", "Pago Pago, American Samoa");
        AEROPORTOS.put("PPT", "Papeete, French Polynesia – Faaa");
        AEROPORTOS.put("PRG", "Prague, Czech Republic – Ruzyne");
        AEROPORTOS.put("PRI", "Praslin Island, Seychelles");
        AEROPORTOS.put("PSA", "Pisa, Italy – G Galilei");
        AEROPORTOS.put("PSZ", "Puerto Suarez, Bolivia");
        AEROPORTOS.put("PTF", "Malololailai, Fiji – Malololailai");
        AEROPORTOS.put("PTP", "Pointe A Pitre, Guadeloupe – Le Raizet");
        AEROPORTOS.put("PTY", "Panama City, Panama – Tocumen Intl");
        AEROPORTOS.put("PUJ", "Punta Cana, Dominican Republic");
        AEROPORTOS.put("PUQ", "Punta Arenas, Chile – Presidente Ibanez");
        AEROPORTOS.put("PUS", "Pusan, South Korea – Kimhae");
        AEROPORTOS.put("PVG", "Shangai, China – Pudong");
        AEROPORTOS.put("PVH", "Porto Velho, Rondônia, RO, Brasil Gov. Jorge Texeira");
        AEROPORTOS.put("PVR", "Puerto Vallarta, Mexico – Gustavo Diaz Ordaz");
        AEROPORTOS.put("PXM", "Puerto Escondido, Oaxaca, Mexico");
        AEROPORTOS.put("PZO", "Puerto Ordaz, Venezuela");
        
		//Aeroportos de sigla Q
        AEROPORTOS.put("QBF", "Vail/Eagle, CO, USA");
        AEROPORTOS.put("QDU", "Duesseldorf, Germany – Train Station");
        AEROPORTOS.put("QKB", "Breckenridge, CO, USA");
        AEROPORTOS.put("QKL", "Cologne, Germany – Train Station");
        AEROPORTOS.put("QRO", "Queretaro, Queretaro, Mexico");
        AEROPORTOS.put("QSY", "Sydney, NSW, Austrália");
        
		//Aeroportos de sigla R
        AEROPORTOS.put("RAB", "Rabaul, Papua New Guinea – Lakunai");
        AEROPORTOS.put("RAI", "Praia, Ilha de Santiago, Cape Verde – Praia");
        AEROPORTOS.put("RAK", "Marrakech, Morocco – Menara");
        AEROPORTOS.put("RAO", "Ribeirão Preto, São Paulo, SP, Brasil – Leite Lopes");
        AEROPORTOS.put("RAR", "Rarotonga, Cook Islands");
        AEROPORTOS.put("RBA", "Rabat, Morocco – Sale");
        AEROPORTOS.put("RBR", "Rio Branco, Acre, AC, Brasil – Plácido de Castro");
        AEROPORTOS.put("RDU", "Raleigh/Durham, NC, USA – Intl");
        AEROPORTOS.put("REC", "Recife, Pernambuco, PE, Brasil – Guararapes / Gilberto Freyre");
        AEROPORTOS.put("REG", "Reggio Calabria, Italy – Tito Menniti");
        AEROPORTOS.put("REL", "Trelew, Chubut, Argentina");
        AEROPORTOS.put("RES", "Resistencia, Chaco, Argentina");
        AEROPORTOS.put("RGA", "Rio Grande, Tierra Del Fuego, Argentina");
        AEROPORTOS.put("RGL", "Rio Gallegos, Santa Cruz, Argentina");
        AEROPORTOS.put("RGN", "Yangon, Myanmar – Mingaladon");
        AEROPORTOS.put("RHO", "Rhodes, Greece – Paradisi");
        AEROPORTOS.put("RIC", "Richmond, VA, USA");
        AEROPORTOS.put("RIX", "Riga, Latvia – Riga");
        AEROPORTOS.put("RKV", "Reykjavik, Iceland – Domestic");
        AEROPORTOS.put("ROM", "Rome, Italy – Leonardo Da Vinci / Fiumicino");
        AEROPORTOS.put("ROP", "Rota, Northern Mariana Islands – Rota");
        AEROPORTOS.put("ROR", "Koror, Palau – Airai");
        AEROPORTOS.put("ROS", "Rosario, Santa Fe, Argentina – Fisherton");
        AEROPORTOS.put("ROV", "Rostov, Russia");
        AEROPORTOS.put("RTB", "Roatan, Honduras – Roatan");
        AEROPORTOS.put("RTM", "Rotterdam, Netherlands");
        AEROPORTOS.put("RUH", "Riyadh, Saudi Arabia – King Khaled Intl");

        //Aeroportos de sigla S
        AEROPORTOS.put("SAB", "Saba Island, Netherlands Antilles");
        AEROPORTOS.put("SAF", "Santa Fe, NM, USA");
        AEROPORTOS.put("SAH", "Sanaa, Yemen – International");
        AEROPORTOS.put("SAL", "San Salvador, El Salvador");
        AEROPORTOS.put("SAN", "San Diego, CA, USA – Lindbergh Intl");
        AEROPORTOS.put("SAP", "San Pedro Sula, Honduras – La Mesa");
        AEROPORTOS.put("SAT", "San Antonio, TX, USA – International");
        AEROPORTOS.put("SAV", "Savannah, GA, USA – Travis Field");
        AEROPORTOS.put("SBA", "Santa Barbara, CA, USA");
        AEROPORTOS.put("SBH", "St Barthelemy, Guadeloupe");
        AEROPORTOS.put("SCL", "Santiago, Chile – Com. Arturo M. Benitez");
        AEROPORTOS.put("SCN", "Saarbruecken, Germany – Ensheim");
        AEROPORTOS.put("SCQ", "Santiago De Compostela, Spain");
        AEROPORTOS.put("SCU", "Santiago, Cuba – Antonio Maceo");
        AEROPORTOS.put("SDJ", "Sendai, Japan – Sendai");
        AEROPORTOS.put("SDQ", "Sto. Domingo, Rep. Dominicana – Las Americas");
        AEROPORTOS.put("SDR", "Santander, Spain – Santander");
        AEROPORTOS.put("SDU", "Rio De Janeiro, RJ, Brasil – Santos Dumont");
        AEROPORTOS.put("SEA", "Seattle, WA, USA – Seattle Tacoma Intl");
        AEROPORTOS.put("SEL", "Seoul, Korea – Kimpo International");
        AEROPORTOS.put("SEZ", "Mahe Island, Seychelles");
        AEROPORTOS.put("SFA", "Sfax, Tunisia – Sfax Airport");
        AEROPORTOS.put("SFG", "St Martin, Netherlands Antilles – Esperance");
        AEROPORTOS.put("SFN", "Santa Fe, Santa Fe, Argentina");
        AEROPORTOS.put("SFO", "San Francisco, CA, USA – Intl");
        AEROPORTOS.put("SGN", "Ho Chi Minh City, Vietnam – Tan Son Nhut");
        AEROPORTOS.put("SHA", "Shanghai, China – Intl /Hongqiao");
        AEROPORTOS.put("SHJ", "Sharjah, United Arab Emirates");
        AEROPORTOS.put("SID", "Sal, Cape Verde – Amilcar Cabral");
        AEROPORTOS.put("SIN", "Singapore, Singapore – Changi");
        AEROPORTOS.put("SJC", "San Jose, CA, USA – International");
        AEROPORTOS.put("SJJ", "Sarajevo, Bosnia Herzegowina – Butmir");
        AEROPORTOS.put("SJK", "São José dos Campos, São Paulo, SP, Brasil");
        AEROPORTOS.put("SJO", "San Jose, Costa Rica – Juan Santamaria International");
        AEROPORTOS.put("SJU", "San Juan, PR, USA – Luis Munoz Marin");
        AEROPORTOS.put("SJW", "Shijiazhuang, China – Shijiazhuang");
        AEROPORTOS.put("SKB", "St Kitts, Saint Kitts And Nevis – Golden Rock");
        AEROPORTOS.put("SKG", "Thessaloniki, Greece");
        AEROPORTOS.put("SKP", "Skopje, Macedonia");
        AEROPORTOS.put("SLA", "Salta, Salta, Argentina");
        AEROPORTOS.put("SLC", "Salt Lake City, UT, USA");
        AEROPORTOS.put("SLU", "St Lucia, Saint Lucia – Vigie Field");
        AEROPORTOS.put("SLZ", "São Luiz, Maranhão, MA, Brasil – Tirirical");
        AEROPORTOS.put("SMF", "Sacramento, CA, USA – Metropolitan");
        AEROPORTOS.put("SNA", "Santa Ana, CA, USA – John Wayne");
        AEROPORTOS.put("SNN", "Shannon, Ireland – Shannon");
        AEROPORTOS.put("SOF", "Sofia, Bulgaria – Sofia Intl");
        AEROPORTOS.put("SPB", "St Thomas Island, VI, USA – Seaplane Base");
        AEROPORTOS.put("SPN", "Saipan, Northern Mariana Islands");
        AEROPORTOS.put("SPR", "San Pedro, Belize");
        AEROPORTOS.put("SRE", "Sucre, Bolivia");
        AEROPORTOS.put("SRQ", "Sarasota/Bradenton, FL, USA");
        AEROPORTOS.put("SSA", "Salvador, Bahia, BA, Brasil – Dep. L. E. Magalhães");
        AEROPORTOS.put("SSH", "Sharm El Sheikh, Egypt – Ophira");
        AEROPORTOS.put("STL", "St Louis, MO, USA – Lambert-St Louis Intl");
        AEROPORTOS.put("STM", "Santarém, Pará, PA, Brasil");
        AEROPORTOS.put("STN", "London, England, UK – Stansted");
        AEROPORTOS.put("STR", "Stuttgart, Germany – Echterdingen");
        AEROPORTOS.put("STT", "St Thomas Island, VI, USA – Cyril E King");
        AEROPORTOS.put("STX", "St Croix Island, VI, USA");
        AEROPORTOS.put("SUB", "Surabaya, Indonesia – Juanda Airport");
        AEROPORTOS.put("SUV", "Suva, Fiji – Nausori");
        AEROPORTOS.put("SVD", "St Vincent, St. Vincent And The Grenadines");
        AEROPORTOS.put("SVG", "Stavanger, Norway – Sola");
        AEROPORTOS.put("SVO", "Moscou, Russia – Sheremetyevo");
        AEROPORTOS.put("SVQ", "Sevilla, Spain");
        AEROPORTOS.put("SVU", "Savusavu, Fiji – Savusavu");
        AEROPORTOS.put("SWP", "Swakopmund, Namibia");
        AEROPORTOS.put("SXB", "Strasbourg, France – Entzheim");
        AEROPORTOS.put("SXF", "Berlin, Germany – Schoenefeld");
        AEROPORTOS.put("SXM", "St Maarten, Netherlands Antilles – Juliana");
        AEROPORTOS.put("SYD", "Sydney, Australia – Sydney /Kingsford-Smith");
        AEROPORTOS.put("SZG", "Salzburg, Austria – Salzburg");
        AEROPORTOS.put("SZX", "Shenzhen, China – Shenzhen");
                
		//Aeroportos de sigla T
        AEROPORTOS.put("TAB", "Tobago, Trinidad & Tobago – Crown Point");
        AEROPORTOS.put("TAE", "Taegu, South Korea");
        AEROPORTOS.put("TAM", "Tampico, Tamaulipas, Mexico");
        AEROPORTOS.put("TAS", "Tashkent, Uzbekistan");
        AEROPORTOS.put("TBS", "Tbilisi, Georgia – Novo Alexeyevka");
        AEROPORTOS.put("TBT", "Tabatinga, Amazonas, AM, Brasil");
        AEROPORTOS.put("TBU", "Nuku Alofa/Tongatapu, Tonga");
        AEROPORTOS.put("TFN", "Tenerife, Canarias, Espanha – Los Rodeos");
        AEROPORTOS.put("TFS", "Tenerife, Canarias, Espanha – Reina Sofia");
        AEROPORTOS.put("TGU", "Tegucigalpa, Honduras – Toncontin");
        AEROPORTOS.put("THE", "Teresina, Piaui, PI, Brasil");
        AEROPORTOS.put("THF", "Berlin, Germany – Tempelhof");
        AEROPORTOS.put("THR", "Tehran, Iran – Mehrabad");
        AEROPORTOS.put("TIA", "Tirana, Albania – Rinas");
        AEROPORTOS.put("TIJ", "Tijuana, Mexico – Gen. Abelardo L Rodriguez");
        AEROPORTOS.put("TIQ", "Tinian, Northern Mariana Islands");
        AEROPORTOS.put("TKK", "Truk, Caroline Islands, Micronesia");
        AEROPORTOS.put("TKS", "Tokushima, Japan");
        AEROPORTOS.put("TKU", "Turku, Finland");
        AEROPORTOS.put("TLH", "Tallahassee, FL, USA");
        AEROPORTOS.put("TLL", "Tallinn, Estonia – Ulemiste");
        AEROPORTOS.put("TLS", "Toulouse, France – Blagnac");
        AEROPORTOS.put("TLV", "Tel Aviv Yafo, Israel – Ben-Gurion");
        AEROPORTOS.put("TNG", "Tangier, Morocco – Boukhalef Souahel");
        AEROPORTOS.put("TNR", "Antananarivo, Madagascar – Ivato");
        AEROPORTOS.put("TOL", "Toledo, OH, USA");
        AEROPORTOS.put("TOS", "Tromso, Norway – Tromso/Langes");
        AEROPORTOS.put("TOY", "Toyama, Japan – Toyama");
        AEROPORTOS.put("TPA", "Tampa, FL, USA – Tampa Intl");
        AEROPORTOS.put("TPE", "Taipei, Taiwan – Chiang Kai Shek");
        AEROPORTOS.put("TRC", "Torreon, Coahuila, Mexico");
        AEROPORTOS.put("TRD", "Trondheim, Norway");
        AEROPORTOS.put("TRN", "Turin, Italy – Caselle");
        AEROPORTOS.put("TRS", "Trieste, Italy – Ronchi Dei Legionari");
        AEROPORTOS.put("TRU", "Trujillo, Peru – Trujillo");
        AEROPORTOS.put("TRV", "Trivandrum, India – Trivandrum");
        AEROPORTOS.put("TRZ", "Tiruchirapally, India");
        AEROPORTOS.put("TSA", "Taipei, Taiwan – Sung Shan");
        AEROPORTOS.put("TSR", "Timisoara, Romania – Timisoara");
        AEROPORTOS.put("TSS", "New York, NY, USA – East 34Th Street Heliport");
        AEROPORTOS.put("TTJ", "Tottori, Japan – Tottori");
        AEROPORTOS.put("TUC", "Tucuman, Argentina – Benjamin Matienzo");
        AEROPORTOS.put("TUF", "Tours, France – St Symphorien");
        AEROPORTOS.put("TUL", "Tulsa, OK, USA");
        AEROPORTOS.put("TUN", "Tunis, Tunisia – Carthage");
        AEROPORTOS.put("TUO", "Taupo, New Zealand – Taupo");
        AEROPORTOS.put("TUS", "Tucson, AZ, USA – International");
        AEROPORTOS.put("TXL", "Berlin, Germany – Tegel");
        AEROPORTOS.put("TZA", "Belize City, Belize");
        AEROPORTOS.put("TZN", "South Andros, Bahamas – Congo Town");
        AEROPORTOS.put("TZX", "Trabzon, Turquia – Trabzon");
        
        //Aeroportos de sigla U
        AEROPORTOS.put("UAK", "Narsarsuaq, Greenland");
        AEROPORTOS.put("UAQ", "San Juan, San Juan, Argentina");
        AEROPORTOS.put("UBJ", "Ube, Japan");
        AEROPORTOS.put("UDR", "Udaipur, India");
        AEROPORTOS.put("UIO", "Quito, Ecuador – Mariscal");
        AEROPORTOS.put("ULN", "Ulan Bator, Mongolia – Ulan Bator");
        AEROPORTOS.put("ULY", "Ulyanovsk, Russia");
        AEROPORTOS.put("UME", "Umea, Sweden – Umea");
        AEROPORTOS.put("URC", "Urumqi, China");
        AEROPORTOS.put("URT", "Surat Thani, Thailand");
        AEROPORTOS.put("USH", "Ushuaia, Tierra Del Fuego, Argentina");
        AEROPORTOS.put("USM", "Koh Samui, Thailand");
        AEROPORTOS.put("USN", "Ulsan, South Korea");
        AEROPORTOS.put("UTH", "Udon Thani, Thailand");
        AEROPORTOS.put("UVF", "St Lucia, Saint Lucia – Hewanorra");
        
		//Aeroportos de sigla V
        AEROPORTOS.put("VAA", "Vaasa, Finland – Vaasa");
        AEROPORTOS.put("VAR", "Varna, Bulgaria – Varna");
        AEROPORTOS.put("VAS", "Sivas, Turkey – Sivas");
        AEROPORTOS.put("VBY", "Visby, Sweden – Visby");
        AEROPORTOS.put("VCE", "Venice, Italy – Marco Polo");
        AEROPORTOS.put("VCP", "Campinas, São Paulo, SP, Brasil – Viracopos");
        AEROPORTOS.put("VDM", "Viedma Gobernador Castello, Argentina");
        AEROPORTOS.put("VDZ", "Valdez, AK, USA");
        AEROPORTOS.put("VFA", "Victoria Falls, Zimbabwe");
        AEROPORTOS.put("VGO", "Vigo, Spain");
        AEROPORTOS.put("VIE", "Vienna, Austria – Schwechat");
        AEROPORTOS.put("VIJ", "Virgin Gorda, Virgin Islands (British)");
        AEROPORTOS.put("VIT", "Vitoria, Spain");
        AEROPORTOS.put("VIX", "Vitoria, Espírito Santo, ES, Brasil – Eurico Sales");
        AEROPORTOS.put("VKO", "Moscou, Russia – Vnukovo");
        AEROPORTOS.put("VLC", "Valencia, Spain – Valencia");
        AEROPORTOS.put("VLG", "Villa Gesell, Buenos Aires, Argentina");
        AEROPORTOS.put("VLI", "Port Vila, Vanuatu – Bauerfield");
        AEROPORTOS.put("VLL", "Valladolid, Spain – Valladolid");
        AEROPORTOS.put("VLN", "Valencia, Venezuela – Valencia");
        AEROPORTOS.put("VNO", "Vilnius, Lithuania – Vilnius Airport");
        AEROPORTOS.put("VNS", "Varanasi, India – Babatpur");
        AEROPORTOS.put("VOG", "Volgograd, Russia – Volgograd");
        AEROPORTOS.put("VRA", "Varadero, Cuba – Juan Gualberto Gomez");
        AEROPORTOS.put("VRB", "Vero Beach, FL, USA – Municipal");
        AEROPORTOS.put("VRN", "Verona, Italy – Verona");
        AEROPORTOS.put("VSA", "Villahermosa, Mexico – Carlos R Perez");
        AEROPORTOS.put("VTE", "Vientiane, Laos – Wattay");
        AEROPORTOS.put("VVI", "Santa Cruz, Bolivia – Viru Viru");
        AEROPORTOS.put("VVO", "Vladivostok, Russia");
        AEROPORTOS.put("VXE", "São Vicente, Cape Verde – São Pedro");
        AEROPORTOS.put("VXO", "Vaxjo, Sweden");
        
		//Aeroportos de sigla W
        AEROPORTOS.put("WAT", "Waterford, Ireland");
        AEROPORTOS.put("WAW", "Warsaw, Poland – Okecie");
        AEROPORTOS.put("WDH", "Windhoek, Namibia – Jg Strijdom");
        AEROPORTOS.put("WIL", "Nairobi, Kenya – Wilson Arpt");
        AEROPORTOS.put("WLG", "Wellington, New Zealand");
        AEROPORTOS.put("WRO", "Wroclaw, Poland – Strachowice");
        AEROPORTOS.put("WAA", "Wales Airport, Wales, Alaska, USA, United States");
        AEROPORTOS.put("WAC", "Wacca Airport, Wacca, Ethiopia");
        AEROPORTOS.put("WAD", "Andriamena Airport, Andriamena, Madagascar");
        AEROPORTOS.put("WAE", "Wadi al-Dawasir Domestic Airport, Wadi ad-Dawasir (Wadi al-Dawaser), Saudi Arabia");
        AEROPORTOS.put("WAF", "Wana Airport, Wana, Pakistan");
        AEROPORTOS.put("WAG", "Whanganui Airport, Whanganui, New Zealand");
        AEROPORTOS.put("WAH", "Harry Stern Airport (FAA: BWP), Wahpeton, North Dakota, United States");
        AEROPORTOS.put("WAI", "Ambalabe Airport, Antsohihy, Madagascar");
        AEROPORTOS.put("WAJ", "Wawoi Falls Airport, Wawoi Falls, Papua New Guinea");
        AEROPORTOS.put("WAK", "Ankazoabo Airport, Ankazoabo, Madagascar");
        
		//Aeroportos de sigla X
        AEROPORTOS.put("XAI", "Xinyang Minggang Airport, Xinyang, Henan, China");
        AEROPORTOS.put("XAL", "Álamos Airport, Álamos, Sonora, Mexico");
        AEROPORTOS.put("XAP", "Serafin Enoss Bertaso Airport, Chapecó, Santa Catarina, SC, Brasil");
        AEROPORTOS.put("XAR", "Aribinda Airport, Aribinda, Burkina Faso");
        AEROPORTOS.put("XAU", "Saül Airport, Saül, French Guiana");
        AEROPORTOS.put("XBB", "Blubber Bay Seaplane Base, Blubber Bay, British Columbia, Canada");
        AEROPORTOS.put("XBE", "Bearskin Lake Airport (TC: CNE3), Bearskin Lake, Ontario, Canada");
        AEROPORTOS.put("XBG", "Bogande Airport, Bogandé, Burkina Faso");
        AEROPORTOS.put("XBJ", "Birjand International Airport, Birjand, Iran");
        AEROPORTOS.put("XBL", "Bedele Airport (Buno Bedele Airport), Bedele, Ethiopia");
        AEROPORTOS.put("XBN", "Biniguni Airport, Biniguni, Papua New Guinea");
        AEROPORTOS.put("XBO", "Boulsa Airport, Boulsa, Burkina Faso");
        AEROPORTOS.put("XBR", "Brockville Regional Tackaberry Airport (TC: CNL3), Brockville, Ontario, Canada");
        AEROPORTOS.put("XCH", "Christmas Island Airport, Christmas Island, Australia");
        AEROPORTOS.put("XCL", "Cluff Lake Airport (TC: CJS3), Cluff Lake, Saskatchewan, Canada");
        AEROPORTOS.put("XCM", "Chatham-Kent Airport, Chatham-Kent, Ontario, Canada");
        AEROPORTOS.put("XCN", "Coron Airport, Coron, Philippines");
        AEROPORTOS.put("XCO", "Colac Airport, Colac, Victoria, Australia");
        AEROPORTOS.put("XCR", "Châlons Vatry Airport, Châlons-en-Champagne, Champagne-Ardenne, France");
        AEROPORTOS.put("XDE", "Diébougou Airport, Diébougou, Burkina Faso");
        AEROPORTOS.put("XDJ", "Djibo Airport, Djibo, Burkina Faso");
        AEROPORTOS.put("XEN", "Xingcheng Airport, Xingcheng, Liaoning, China");
        AEROPORTOS.put("XES", "Grand Geneva Resort Airport, Lake Geneva, Wisconsin, United States");
        AEROPORTOS.put("XFN", "Xiangyang Liuji Airport, Xiangyang, Hubei, China");
        AEROPORTOS.put("XFW", "Hamburg Finkenwerder Airport, Hamburg, Germany");
        AEROPORTOS.put("XGA", "Gaoua Airport (Amilcar Cabral Airport), Gaoua, Burkina Faso");
        AEROPORTOS.put("XGG", "Gorom Gorom Airport, Gorom-Gorom, Burkina Faso");
        AEROPORTOS.put("XGN", "Xangongo Airport, Xangongo, Angola");
        AEROPORTOS.put("XGR", "Kangiqsualujjuaq (Georges River) Airport, Kangiqsualujjuaq, Quebec, Canada");
        AEROPORTOS.put("XIJ", "Ahmad al-Jaber Air Base 1, Al Ahmadi, Kuwait");
        
		//Aeroportos de sigla Y
        AEROPORTOS.put("YAP", "Yap, Caroline Islands, Micronesia");
        AEROPORTOS.put("YBA", "Banff, Alberta, Canada");
        AEROPORTOS.put("YDF", "Deer Lake, Newfoundland, Canada");
        AEROPORTOS.put("YEC", "Yechon, South Korea");
        AEROPORTOS.put("YEG", "Edmonton, Alberta, Canada – Intl");
        AEROPORTOS.put("YHD", "Dryden, Ontario, Canada");
        AEROPORTOS.put("YHM", "Hamilton, Ontario, Canada – Civic");
        AEROPORTOS.put("YHZ", "Halifax, Nova Scotia, Canada");
        AEROPORTOS.put("YKS", "Yakutsk, Russia");
        AEROPORTOS.put("YLW", "Kelowna, British Columbia, Canada");
        AEROPORTOS.put("YMX", "Montreal, Quebec, Canada");
        AEROPORTOS.put("YOW", "Ottawa, Ontario, Canada – Intl");
        AEROPORTOS.put("YQB", "Quebec, Canada – Sainte Foy Airport");
        AEROPORTOS.put("YQG", "Windsor, Ontario, Canada – Intl");
        AEROPORTOS.put("YQR", "Regina, Saskatchewan, Canada");
        AEROPORTOS.put("YQX", "Gander, Newfoundland, Canada");
        AEROPORTOS.put("YTZ", "Toronto, Ontario, Canada");
        AEROPORTOS.put("YUL", "Montreal, Quebec, Canada");
        AEROPORTOS.put("YUM", "Yuma, AZ, USA – International");
        AEROPORTOS.put("YVR", "Vancouver, British Columbia, Canada");
        AEROPORTOS.put("YVZ", "Deer Lake, Ontario, Canada");
        AEROPORTOS.put("YWG", "Winnipeg, Manitoba, Canada");
        AEROPORTOS.put("YWH", "Victoria, British Columbia, Canada");
        AEROPORTOS.put("YXD", "Edmonton, Alberta, Canada");
        AEROPORTOS.put("YYC", "Calgary, Alberta, Canada");
        AEROPORTOS.put("YYJ", "Victoria, British Columbia, Canada");
        AEROPORTOS.put("YYR", "Goose Bay, Newfoundland, Canada");
        AEROPORTOS.put("YYT", "St Johns, Newfoundland, Canada");
        AEROPORTOS.put("YYU", "Kapuskasing, Ontario, Canada");
        AEROPORTOS.put("YYY", "Mont Joli, Quebec, Canada");
        AEROPORTOS.put("YYZ", "Toronto, Ontario, Canada – Pearson Intl");
        AEROPORTOS.put("YZF", "Yellowknife, NW Territories, Canada");
        
		//Aeroportos de sigla Z
        AEROPORTOS.put("ZAG", "Zagreb, Croatia (Hrvatska) – Zagreb");
        AEROPORTOS.put("ZAH", "Zahedan, Iran – Zahedan");
        AEROPORTOS.put("ZAL", "Valdivia, Chile – Pichoy");
        AEROPORTOS.put("ZAM", "Zamboanga, Philippines");
        AEROPORTOS.put("ZAZ", "Zaragoza, Spain – Zaragoza");
        AEROPORTOS.put("ZBV", "Vail/Eagle, CO, USA");
        AEROPORTOS.put("ZCL", "Zacatecas, Zacatecas, Mexico");
        AEROPORTOS.put("ZCO", "Temuco, Chile – Manquehue");
        AEROPORTOS.put("ZHA", "Zhanjiang, China");
        AEROPORTOS.put("ZIH", "Ixtapa/Zihuatanejo, Guerrero, Mexico");
        AEROPORTOS.put("ZLO", "Manzanillo, Colima, Mexico");
        AEROPORTOS.put("ZNZ", "Zanzibar, Tanzania – Kisauni");
        AEROPORTOS.put("ZRH", "Zurich, Switzerland – Zurich");
        AEROPORTOS.put("ZSA", "San Salvador, Bahamas");
        AEROPORTOS.put("ZTH", "Zakinthos, Greece – Zakinthos");
        
    }

    public String getSiglaAeroporto(String query) {
        String naoAchei = "404";
        Map<String, String> matches = new HashMap<>();

        // Se a consulta já é uma sigla existente, retorne a sigla
        if (AEROPORTOS.containsKey(query)) {
            return query;
        }

        for (Map.Entry<String, String> entry : AEROPORTOS.entrySet()) {
            String airportName = entry.getValue().toLowerCase();
            // Agora, em vez de verificar apenas o início, verificamos se a consulta está contida em qualquer parte do nome do aeroporto.
            if (airportName.contains(query.toLowerCase())) {
                matches.put(entry.getKey(), entry.getValue());
            }
        }

        if (matches.size() == 1) {
            return matches.keySet().iterator().next();
        } else if (matches.size() > 1) {
            
            // Encontre a correspondência com o maior número de caracteres em comum com a consulta
            int maxMatchLength = 0;
            String maxMatchKey = null;
            for (Map.Entry<String, String> entry : matches.entrySet()) {
                int matchLength = getCommonsLength(query, entry.getValue()); 
                if (matchLength > maxMatchLength) {
                    maxMatchLength = matchLength;
                    maxMatchKey = entry.getKey();
                } else if (matchLength == maxMatchLength) {
                    // Se houver um empate, escolha aleatoriamente entre as duas correspondências
                    if (new Random().nextBoolean()) {
                        maxMatchKey = entry.getKey();
                    }
                }
            }
            
            return maxMatchKey;
            
        } else {
        	
        	LOGGER.error("Erro: Não foi possível encontrar aeroporto");
            return naoAchei; 
            
        }
    }

    
    public static int getCommonsLength(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        int commonsLength = 0;
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                commonsLength++;
            } else {
                break;
            }
        }
        return commonsLength;
    }
   
    
}
