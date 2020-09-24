package com.ehappy.exlistview04;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView lstPrefer;
    TextView txtview;
    int[] resIds = new int[]{ R.drawable.ncue, R.drawable.dyu,R.drawable.ctu, R.drawable.mdu,R.drawable.ccut,R.drawable.ncnu,R.drawable.nkut,R.drawable.iktcds,R.drawable.yuntech,R.drawable.nfu
            ,R.drawable.twu,R.drawable.ccu,R.drawable.nhu,R.drawable.wfu,R.drawable.toko,R.drawable.cjc,R.drawable.ncyu,R.drawable.ttc,R.drawable.ncku,R.drawable.tnnua,R.drawable.nutn
            ,R.drawable.ntin,R.drawable.stust,R.drawable.ksu,R.drawable.cnu,R.drawable.cjcu,R.drawable.tut,R.drawable.feu,R.drawable.hwai,R.drawable.tsu,R.drawable.ctbc,R.drawable.mhchcm
            ,R.drawable.ttcs};
    String[] schools= new String[] {"國立彰化師範大學","大葉大學","建國科技大學","明道大學","中州科技大學"
            ,"國立暨南國際大學","南開科技大學","一貫道崇德學院","國立雲林科技大學","國立虎尾科技大學","環球科技大學"
            ,"國立中正大學","南華大學","吳鳳科技大學","稻江科技暨管理學院","崇仁醫護管理專科學校","國立嘉義大學","大同技術學院"
            ,"國立成功大學","國立臺南藝術大學","國立臺南大學","國立臺南護理專科學校","南臺科技大學","崑山科技大學"
            ,"嘉南藥理大學","長榮大學","台南應用科技大學","遠東科技大學","中華醫事科技大學"
            ,"台灣首府大學","中信金融管理學院","敏惠醫護管理專科學校","台灣基督長老教會南神神學院"};
    String[] website = { "www.ncue.edu.tw", "www.dyu.edu.tw","www.ctu.edu.tw","www.mdu.edu.tw","www.ccut.edu.tw","www.ncnu.edu.tw","www.nkut.edu.tw",
            "www.iktcds.edu.tw","www.yuntech.edu.tw","www.nfu.edu.tw","www.twu.edu.tw","www.ccu.edu.tw","www.nhu.edu.tw"
            ,"www.wfu.edu.tw","ww.toko.edu.tw","www.cjc.edu.tw","www.ncyu.edu.tw","main.ttc.edu.tw","web.ncku.edu.tw"
            ,"www.tnnua.edu.tw","www.nutn.edu.tw","www.ntin.edu.tw","www.stust.edu.tw","www.ksu.edu.tw","www.cnu.edu.tw"
            ,"www.cjcu.edu.tw","www.tut.edu.tw","www.feu.edu.tw","www.hwai.edu.tw","web.tsu.edu.tw","www.ctbc.edu.tw"
            ,"www.mhchcm.edu.tw","www.ttcs.edu.tw"};
    String[] introdution = {"國立彰化師範大學，設教育學院、科學教育學院、及職業教育學院等3個學院，附屬學校並隨之改名為「國立彰化師範大學附屬高級工業職業學校」。",
            "大葉大學，位於彰化縣大村鄉山腳路、八卦山山麓，中文簡稱大葉、英文簡稱DYU，是台灣著名的私立綜合大學，大葉大學設有工學院、管理學院、設計暨藝術學院、外語學院和生物科技暨資源學院等5所學院；大葉大學創校於西元1990年，當時為大葉工學院，以師徒制和產學結合作為創校手法，希望培育出具創意且優質的學子青年，至1997年大葉工 ...",
            "建國科技大學，成為彰化縣內第一所科技大學。 本校位於八卦山彰化縣立體育場旁，距離彰化火車站約8分鐘，高鐵臺中站約30分鐘車程，學校面積佔地10.5公頃，設有工程、設計、管理、生活科技四個學院，18個學系，9個研究所(碩士班)。",
            "明道大學，是一所臺灣私立大學，前身為明道管理學院，位在彰化縣埤頭鄉。 ... 校總部學術單位有五個學院：管理學院、應用科學院、設計學院、人文學院、餐旅觀光學院，22學系（含碩士6學系、博士2學系），校內並設有明道新聞臺。",
            "中州科技大學，學校發展調整為工、觀光與管理、健康三學院，並設有保健食品研發暨檢驗中心、工業智動化研究中心、智慧雲端與大數據研究中心三個中心，確立以產業技術、服務管理、健康產業為教學研究多元發展之重點與特色，以利學校永續經營與發展，並為國家培育具實務能力和人文素養的優質技職人才之目標。",
            "國立暨南國際大學位於臺灣地理中心南投縣埔里鎮，成立於民國84年，以『誠樸弘毅，務本致用』的教育理念，期許培養『誠樸以立身，弘毅以持志，務本以治學，致用以經世』的知識青年，具開闊心胸，堅忍不拔、誠懇樸實的品格，並以人文關懷精神為本，開創科技新知為用，造福人群社會。 校名「暨南」二字，取自《尚書．",
            "南開科技大學是位於臺灣南投縣草屯鎮的一所私立科技大學，與暨南國際大學為南投縣惟二的兩間大學。 原名南開技術學院，2008年改名為南開科技大學，招收研究所、四技、五專的學生。 近年來國外學生逐年增加。",
            "一貫道崇德學院，源於一貫道在臺十八組線內的發一組，其下各支線公推發一崇德創辦前人「不休息菩薩」陳鴻珍(1923-2007)擔任創辦人。 該校以復興道德文化，終身學習，落實學道為三辦學目標。",
            "國立雲林科技大學，多媒體簡介 本校成立於1991年，在歷任校長及現任校長侯春看博士卓越的領導，已成為一所績效卓越之典範科技大學。 設校理念： YunTech教育理念為理論與實務並重，人文與科技兼備，秉持｢誠敬恆新｣之校訓，培育具「知識整合能力」、「國際競爭優勢」、「人文與科技兼備」之高級專業人才。",
            "國立虎尾科技大學，簡稱虎科、虎科大、虎尾科大，位於中華民國雲林縣虎尾鎮之一所國立技職院校，前身為雲林工專目前設有目前有工程、管理、電機資訊、文理四個學院。現為雲林國立大學聯盟成員 ",
            "環球學校財團法人環球科技大學，簡稱環科或環科大，是位於中華民國（臺灣）中部雲林縣斗六市的一所私立科技大學，1989年，前中國醫藥學院院長郭榮趙先生應當時雲林縣縣長許文志先生之邀，於雲林縣設校。1992年，奉教育部函核准立案招生，校名為「環球商業專科學校」。",
            "國立中正大學，簡稱中正大學、中正大、中正、正大，是一所位於臺灣嘉義縣民雄鄉的國立大學，亦為臺灣綜合大學系統的成員。其設有文、理、社會科學、工、管理、法、教育七學院，並以社會科學、法學、電腦科學等領域見長。其中，法學院為臺灣南部地區的大學中最具規模者。",
            "南華大學位於嘉義縣大林鎮，成立於1996年是佛光山星雲大師凝聚百萬信眾力量所創辦的高等教育學府。校地面積約63公頃，依山建築、漸層有次，擁有遼闊的草原、 ..."
            ,"吳鳳科技大學，全銜為吳鳳學校財團法人吳鳳科技大學，簡稱吳鳳科大，是位於中華民國嘉義縣民雄鄉的一所科技大學，共有17個系、4個研究所碩士班。 於2010年8月奉教育部核定改名為吳鳳科技大學。 現有安全工程、數位管理、觀光餐旅、醫學健康等學院及教學中心。",
            "，稻江科技暨管理學院，是創辦人陳璽安先生、陳阿財先生等，響應政府鼓勵民間興學政策，選定人文薈萃之嘉義縣境創設本校。 ... 2015年張淑中教授榮任第六任校長，為因應少子化危機，規劃學校朝「小而美、小而精緻、小而優質」的方向經營並結合地方兼國家級的觀光資源（如故宮南院），將稻江在南台灣發展出具有獨特優勢的學校特色。"
            ,"崇仁醫護管理專科學校（簡稱崇仁醫專 、崇仁護專、崇仁專校、CJC）是一間位於臺灣嘉義的專科學校，目前有5個學科，學程期止並發學位證書或結業證書。",
            "國立嘉義大學，簡稱嘉義大學、嘉大、NCYU，校本部位於臺灣嘉義市東區的一所國立大學。2000年2月由國立嘉義技術學院與國立嘉義師範學院整併而成[2]:601-609。前身為日治時期大正八年（1919年）4月創立的「臺灣總督府嘉義農林學校」[2]:567-582及民國四十六年（1957年）創立的「臺灣省立嘉義師範學校」[2]:583-593。設有蘭潭校區[3]、林森校區[4]、新民校區[5]及民雄校區（位於嘉義縣）[6]等四個校區，並設有師範、人文藝術、管理、農、理工、生命科學及獸醫學院等七個學院，三十九個學系、四個碩士學位學程、三十八個碩士班、十五個碩士在職專班、六個博士班、一個博士學位學程[7]，另有附設實驗國民小學一所，並與世界各國等六十七所大學締結為姐妹校[8]，是嘉義市唯一歷史最悠久、最具規模的國立綜合大學[2]:601[9]。",
            "大同技術學院，簡稱大同學院，是位於臺灣嘉義市東區的一所以棒球聞名的私立技術學院，對面即為嘉嘉雲高職第一志願國立嘉義高級工業職業學校，目前有嘉義及太保兩校區，並有2學群、8系科，招收四技、二技、二專、五專、進修部(夜間部)學生。（太保校區已暫停使用，目前僅存嘉義校區尚在營運）",
            "國立成功大學，簡稱成大、成功大學，是一所位於臺灣臺南市的國立大學，該校是教育部高教深耕計畫中參與全球連結全校型計畫的4所學校之一，名稱由來為紀念延平郡王鄭成功開臺之功。前身為1931年台灣日治時期創辦的「臺灣總督府臺南高等工業學校」，二戰後國民政府於1946年接收，改制為「臺灣省立臺南工業專科學校」，同年底升格為「臺灣省立工學院」（臺灣省僅有的三所省立學院，另二所為臺灣省立農學院、臺灣省立師範學院）[3]，1971年改制為國立成功大學[4]。目前校總區由相互緊鄰的8大校區組成，另擁有安南校區、歸仁校區及斗六校區。",
            "國立臺南藝術大學，簡稱臺南藝大、南藝大或南藝，是一所位於中華民國（臺灣）臺南市的藝術大學，前身為1996年由知名建築教育長老漢寶德先生所創校的國立臺南藝術學院，校園座落於烏山頭水庫旁。現有5個學系（含3個碩士班）、9個研究所（含1個博士班），以高階之研究所階段藝術教育為主軸，並發展大學部及七年一貫制之教學單位，目前學生總人數1,470人。",
            "國立臺南大學，是一所位於中華民國臺灣臺南市中西區的國立大學，北側臨國立臺南女子高級中學，前身為「省立臺南師專」，歷經多次改制而成，是一所擁有120年校史的大學，是臺南府城歷史最悠久的高等教育機構，歷經師範、師專、師範學院時期，在2004年成功轉型為具教育、人文、理工、環境與生態、藝術與管理六大學院的綜合型大學。",
            "國立臺南護理專科學校，創立於1952年6月，位於臺灣臺南市中西區。為臺灣唯一一所國立護理專科學校，目前招生學制包含有五年制副學士班（五專）、二年制副學士班（二專）日夜間部，五年制副學士班（五專）設有護理科、化妝品應用科、老人服務事業科，日夜二年制副學士班（二專）設有化妝品應用科、老人服務事業科，男女兼收。",
            "南臺科技大學，正式全銜為南臺學校財團法人南臺科技大學，簡稱南臺科大，是位於臺灣臺南市永康區的一所私立科技大學。前身私立南台工業技藝專科學校成立於1969年，後與於1970年成立之私立永光工業專科學校合併。南臺科大於2002年4月向經濟部智慧財產局申請「南科大」（S.T.U.T）、南台科大註冊簡稱，此後只限南臺科大一校使用。",
            "崑山科技大學，全銜為財團法人崑山科技大學，簡稱崑山科大、崑科大，位於臺南市永康區崑山里崑大路，面積22.3483 公頃。於1965年4月29日經教育部核定為「崑山工商專科學校」。2000年奉教育部核定改名為科技大學。現有工程學院、商業管理學院、創意媒體學院、民生應用學院、國際學院等5個學院。",
            "嘉南藥理大學，是設在臺灣臺南市仁德區的私立技職型大學，為臺灣設有藥學系的九所大專院校之一，主要培養從事醫藥、衛生與管理，以及「健康樂活服務產業」之專業人才。目前共設置5個學院、24個系所。",
            "長榮大學，學校介紹：大學網整理了長榮大學的交通方式、宿舍介紹，以及全校跟各學院男女生比例，讓您能夠在入學前，對長榮大學有更深的了解。",
            "台南應用科技大學，學校正式全銜為台南家專學校財團法人台南應用科技大學，簡稱南應大、南應、南科、台南應用科大、台南科大、TUT。舊稱台南家專、台南女專、台南女院、台南女技或台南女子大學等等，是一所位於臺灣臺南永康區的私立科技大學，目前有生活科技學院、管理學院、設計學院、藝術學院、旅遊學院等，創校起初至台南女技的期間約莫40年僅招收女性，在2005年為求升格為科技大學，新增了部分非學校專科的系所(如：設計科、工科及商科)，改制為科技大學後，亦開始初步招收男性，並且更改部分系所的全銜，以淡化先前女校的色彩，如：家政系就改名為生活科學系及生活服務產業系，服裝系改名為服飾設計管理系。在全臺灣服飾設計相關校系中，台南應用科技大學服飾設計管理系是唯一設有旗袍製作課程的學校，同時也是全台大學院校中更改家政系名但保留家政系課綱&學程最完整的學校",
            "遠東科技大學，簡稱遠東科大，是一所位於中華民國臺灣臺南市新市區的科技大學（近南部科學園區，新市車站附近），目前有3個學院、20個系、6個研究所。",
            "中華醫事科技大學，簡稱中華醫大、華醫是一所位於臺灣台南市仁德區的科技大學，建校於1968年，2007年改名「中華醫事科技大學」。現任校長為曾信超",
            "臺灣首府大學，全名首府學校財團法人台灣首府大學，常簡稱為台首大、首府，是一所位於臺灣臺南麻豆的私立大學。於2000年創校。設有教育與設計、休閒產業及旅館管理三個學院，計有六個學系、三研究所，並附設兩間五星級教學飯店蓮潭國際會館、高雄國際會館。",
            "中信金融管理學院，簡稱中金院，是一所位於臺南市安南區的私立大專院校，前身為成立於2000年的興國管理學院，2015年因獲中信金控捐資而重組更名[1]。",
            "敏惠醫護管理專科學校，是一間位於中華民國臺南市柳營區的專科學校，目前有5個學科。",
            "台灣基督長老教會，是台灣的基督新教長老宗組織，為普世教會協會、台灣教會合作協會成員。成立於1951年，但其歷史可追溯至1865年在高雄旗津建立的臺灣第一間新教教會。其會徽主要由長老宗的共同標誌「燃燒的荊棘」，加上會名的臺語白話字組合而成。"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 取得介面元件
        lstPrefer=(ListView)findViewById(R.id.lstPrefer);
        txtview=(TextView)findViewById(R.id.textView2);
        // 建立自訂的 Adapter
        MyAdapter adapter=new MyAdapter(this);

        // 設定 ListView 的資料來源
        lstPrefer.setAdapter(adapter);
        lstPrefer.setOnItemClickListener(lstPreferListener);
        lstPrefer.setOnItemLongClickListener(lstLongPreferListener);
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater myInflater;
        public MyAdapter(Context c){
            myInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount(){
            return schools.length;
        }
        @Override
        public Object getItem(int position){
            return schools[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            convertView = myInflater.inflate(R.layout.mylayout, null);

            // 取得 mylayout.xml 中的元件
            ImageView imgLogo = (ImageView) convertView.findViewById(R.id.imgLogo);
            TextView txtName = ((TextView) convertView.findViewById(R.id.txtName));
            TextView txtengName = ((TextView) convertView.findViewById(R.id.txtengName));

            // 設定元件內容
            imgLogo.setImageResource(resIds[position]);
            txtName.setText(schools[position]);
            txtengName.setText(website[position]);
            //或 txtName.setText(""+getItem(position));

            return convertView;
        }
    }
    private ListView.OnItemClickListener lstPreferListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            txtview.setText(introdution[position]);

        }
    };
    private ListView.OnItemLongClickListener lstLongPreferListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent();
            String name="http://"+website[position]+'/';
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(name));
            startActivity(intent);
            return false;
        }
    };
}