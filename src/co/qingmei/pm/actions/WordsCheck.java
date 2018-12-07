package co.qingmei.pm.actions;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsCheck {

    public static void main(String[] args) throws FileNotFoundException {


        new WordsCheck().work();
    }



    //瀹氫箟澶х被闆嗗悎
    Map<String, Integer> jrava = new HashMap<String, Integer>();
    Map<String, Integer> web = new HashMap<String, Integer>();
    Map<String, Integer> mobile = new HashMap<String, Integer>();
    Map<String, Integer> db = new HashMap<String, Integer>();
    Map<String, Integer> others = new HashMap<String, Integer>();

    //瀹氫箟鍒嗙被鍗曡瘝
    String  javaKeyWords =  "io,ssh,snmp,oop,ejb,pojo,mq,junit,jvm,soap,tcp,mvc,java,spring,hibernate,struts,mybatis";
    String  webKeyWords = "css,div,dom,prototype,echarts,jsp,http,w3c,mvvm,grovy,html,jquery,js,angular,ajax,css,json,xml,web,bootstrape,react,ext";
    String  mobileKeyWords = "绉诲姩,瀹夊崜, ios,寰俊,鏀粯,app";
    String  dbKeyWords = "mysql,nosql,redis,oracle,sqlserver,mongodb";


    private void   print(){

        int  dropNum=1;
        //杈撳嚭锛�
        int i=0;
        System.out.println("java鍚庡彴鎶�鏈細"+jrava.size());
        for(String k :jrava.keySet()){
            if(jrava.get(k)<dropNum)
                continue;
            System.out.print(k+ ":" + jrava.get(k) +"   ,");
            if (++i%5==0)
                System.out.println();
        }


        System.out.println("\nweb鎶�鏈細"+web.size());
        for(String k :web.keySet()){
            if(web.get(k)<dropNum)
                continue;
            System.out.print(k+ ":" + web.get(k) +"   ,");
            if (++i%5==0)
                System.out.println();
        }

        System.out.println("\n绉诲姩寮�鍙戞妧鏈細"+mobile.size());
        for(String k :mobile.keySet()){
            if(mobile.get(k)<dropNum)
                continue;
            System.out.print(k+ ":" + mobile.get(k) +"   ,");
            if (++i%5==0)
                System.out.println();
        }


        System.out.println("\n 鏁版嵁搴撴妧鏈細"+db.size());
        for(String k :db.keySet()){
            if(db.get(k)<dropNum)
                continue;
            System.out.print(k+ ":" + db.get(k) +"   ,");
            if (++i%5==0)
                System.out.println();
        }

        System.out.println("\n 鍏朵粬鎶�鏈細"+others.size());
        for(String k :others.keySet()){
            if(others.get(k)<dropNum)
                continue;

            System.out.print(k+ ":" + others.get(k) +"   ,");
            if (++i%5==0)
                System.out.println();
        }
    }


    private   void  putInMap(String  word){


        word = word.trim();
        String  mmm= word.length()>=3?word.substring(1,3):word;
        if (javaKeyWords.indexOf(mmm)> -1){
            Integer cnt =jrava.get(word);
            cnt = cnt==null?1:++cnt;
            jrava.put(word,cnt);
        }else
        if (webKeyWords.indexOf(mmm)> -1){
            Integer cnt =web.get(word);
            cnt = cnt==null?1:++cnt;
            web.put(word,cnt);
        }else

        if (mobileKeyWords.indexOf(mmm)> -1){
            Integer cnt =mobile.get(word);
            cnt = cnt==null?1:++cnt;
            mobile.put(word,cnt);
        }else
        if (dbKeyWords.indexOf(mmm)> -1){
            Integer cnt =db.get(word);
            cnt = cnt==null?1:++cnt;
            db.put(word,cnt);
        }else
        {
            Integer cnt =others.get(word);
            cnt = cnt==null?1:++cnt;
            others.put(word,cnt);
        }


    }

    private  void  matchWord(String str){
        String s =   "[a-z,A-Z,\\s]+";//"\\w+ \\w+|\\w+";//"\\d+.\\d+|\\w+";
        Pattern pattern=Pattern.compile(s);
        Matcher ma=pattern.matcher(str);
        while(ma.find())
        {
            String www= ma.group().toLowerCase();

            try {
                Integer.parseInt(www);
                continue;
            }catch (Exception eee){

            }

            if (www.isEmpty())
                continue;
           // System.out.println(":"+www);
            this.putInMap(www);

        }
    }


    public  void  work() throws FileNotFoundException {



        BufferedReader bre = null;
        try {
            String line;
            String file = "F:\\aaaa.txt";
            bre = new BufferedReader(new FileReader(file));//file涓烘枃浠剁殑璺緞+鏂囦欢鍚嶇О+鏂囦欢鍚庣紑
            while ((line = bre.readLine()) != null) {
                System.out.println("-------------");//鍘熸牱杈撳嚭璇诲埌鐨勫唴瀹�

                //褰掔被
                if (!line.trim().equals(""))
                    this.matchWord(line);
            }


        } catch (IOException e) {
            System.out.println("琛岃鍙栭敊璇�");
        }

        this.print();


    }



    public WordsCheck() throws FileNotFoundException {
    }



}
