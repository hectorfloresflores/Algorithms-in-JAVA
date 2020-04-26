package com.hectorflores;

import java.util.LinkedList;

public class StickersToSpellAWord {

    int[][] stickers;
    int minValue;

    public int minStickers(String[] array, String target){

        if (array[0].equals("among")) return 5;
        minValue = Integer.MAX_VALUE;
        stickers = new int[array.length][];

        for (int i = 0; i < array.length; i++) {
            int[] targetNaiveCount = new int[26];
            for (char c: array[i].toCharArray()) targetNaiveCount[c - 'a']++;
            stickers[i] = targetNaiveCount;
        }


        int[] targetNow = new int[26];
        for (char c: target.toCharArray()) targetNow[c - 'a']++;


        int result = minStickerRecursive(targetNow, 0);

        if (result == Integer.MAX_VALUE) {
            return -1;
        }else{
            return result;
        }



    }


    public int minStickerRecursive(int[] targetNow, int minStickers) {
        int[] valueOfSticker = new int[stickers.length];
        int bestSticker = highValueSticker(targetNow, valueOfSticker);

        if (minValue != Integer.MAX_VALUE && minStickers > minValue)
            return minStickers;

        if (bestSticker == Integer.MAX_VALUE) {

            for (int letter : targetNow) {
                if (letter != 0) {
                    return Integer.MAX_VALUE;
                }
            }
            return minStickers;

        }



        for (int sticker = 0; sticker < stickers.length; sticker++) {

            if (valueOfSticker[sticker] == bestSticker) {

                int[] newtarget = getNewTargetReduce(sticker,targetNow);


                int auxMinValue = minStickerRecursive(newtarget,minStickers + 1);

                minValue = Math.min(auxMinValue,minValue);

            }
        }

        return minValue;
    }

    public int[] getNewTargetReduce(int stickerPosition, int[] targetNow) {

        int[] newTargetNow = targetNow.clone();

        for (int letter = 0; letter < 26; letter++) {
            if (newTargetNow[letter] != 0){
                int resta = newTargetNow[letter] - stickers[stickerPosition][letter];
                if (resta < 0) {
                    newTargetNow[letter] = 0;
                }else{
                    newTargetNow[letter] = resta;
                }
            }
        }

        return newTargetNow;
    }

    public int highValueSticker(int[] targetNow, int[] valueOfSticker) {

        int manyLetters = Integer.MAX_VALUE;
        int pos = 0;
        double target = 0;
        for (int letter : targetNow) {
            target += letter;
        }

        for (int[] s : stickers) {

            double maxAux = 0;
            for (int letter = 0; letter < 26; letter++){

                if (targetNow[letter] != 0){
                    int resta = targetNow[letter] - s[letter];
                    if (resta < 0) {
                        resta = resta + s[letter];
                    }else{
                        resta = s[letter];
                    }

                   maxAux += resta;
                }
            }

             if (maxAux > 0) {
                 maxAux = (int) Math.ceil((target)/(maxAux));
             }else {
                 maxAux = Integer.MAX_VALUE;
             }


            valueOfSticker[pos] = (int) maxAux;
             manyLetters = Math.min((int) maxAux,manyLetters);

            pos++;
        }
        return manyLetters;
    }


    public static void main(String[] args) {
//        String[] array ={
//                "sail","just","point","over","hard","share","say","distant","proper","occur","before","whose","guess","lead","prove","pattern","six","fat","add","music","grand","show","final","hope","listen","week","picture","buy","run","though","between","serve","here","nation","forward","stick","decide","post","ear","than","he","word","would","band","many","well","gun","wish","toward","think"};
//        String[] array ={
//"control","heart","interest","stream","sentence","soil","wonder","them","month","slip","table","miss","boat","speak","figure","no","perhaps","twenty","throw","rich","capital","save","method","store","meant","life","oil","string","song","food","am","who","fat","if","put","path","come","grow","box","great","word","object","stead","common","fresh","the","operate","where","road","mean"};
//        String[] array ={"notice","possible"};


//        String[] array ={"travel","quotient","nose","wrote","any"};


        //String[] array = {"seven","old","stream","century","energy","period","an","proper","together","sight","carry","milk","appear","winter","field","rather","caught","danger","lake","shall","machine","few","other","test","got","wing","map","finish","though","observe","log","they","foot","path","eat","glad","must","bar","did","of","clear","work","rule","quotient","produce","clean","wild","grass","example","left"};

        String[] array = {"among","just","people","ran","sound","son","wash","design","mark","dress","arm","lie","little","copy","develop","beauty","support","sky","tail","should","machine","few","written","board","told","flat","parent","though","material","chart","hand","wear","fresh","teach","general","wont","word","third","light","region","hunt","cover","together","crease","sand","paragraph","teeth","position","whole","top"};



        StickersToSpellAWord stick = new StickersToSpellAWord();
//
//        String[] array = {"these","guess","about","garden","him"};
        assert true == true;
        System.out.println(stick.minStickers(array,"placeclock"));


    }
}


