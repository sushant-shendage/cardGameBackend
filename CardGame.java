import java.util.Arrays;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
int gameLoopVariable=0;
        do {
        System.out.println("new game started here...!");
        Scanner sc = new Scanner(System.in);
        
        int cardSet[] = OriginalSet(), rejectedCardSet[] = new int[0];
        int replaceCardp1=0,rejectedCard,randomCardp1,accept,rCardOrCardSetp1;
        System.out.println(Arrays.toString(cardSet));

        int p1Cards[] = new int[0];
        int p2Cards[] = new int[0];

        int randomEle;

        System.out.println("cardSet :: " + Arrays.toString(cardSet));
        System.out.println("p1Cards :: " + Arrays.toString(p1Cards));
        System.out.println("p2Cards :: " + Arrays.toString(p2Cards));
        System.out.println("rejectedCardSet :: " + Arrays.toString(rejectedCardSet));

        for (int i = 0; i < 6; i++) {
            randomEle = cardSet[generateRandomNum(cardSet.length)];
            p1Cards = add(p1Cards, randomEle);
            cardSet = remove(cardSet, randomEle);
        }
        for (int i = 0; i < 6; i++) {
            randomEle = cardSet[generateRandomNum(cardSet.length)];
            p2Cards = add(p2Cards, randomEle);
            cardSet = remove(cardSet, randomEle);
        }

        System.out.println("cardSet :: " + Arrays.toString(cardSet));
        System.out.println("p1Cards :: " + Arrays.toString(p1Cards));
        System.out.println("p2Cards :: " + Arrays.toString(p2Cards));
        System.out.println("rejectedCardSet :: " + Arrays.toString(rejectedCardSet));

        p1Cards = sortCards(p1Cards);
        p2Cards = sortCards(p2Cards);
        System.out.println("sorted_p1Cards :: " + Arrays.toString(p1Cards) + " pair status :: " + pairCal(p1Cards));
        System.out.println("sorted_p2Cards :: " + Arrays.toString(p2Cards) + " pair status :: " + pairCal(p2Cards));

        System.out.println("cards given to players...!");
        System.out.println("----------------------------------------------");
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        for (;;) 


        {











if (pairCal(p1Cards)==3|| pairCal(p2Cards)==3) {
    break;
}



            System.out.println("new game started...!");
            // System.out.println("~~ cardSet         :: " + Arrays.toString(cardSet));
            // System.out.println(
            //         "~~ sorted_p1Cards  :: " + Arrays.toString(p1Cards) + " pair status :: " + pairCal(p1Cards));
            // System.out.println(
            //         "~~ sorted_p2Cards  :: " + Arrays.toString(p2Cards) + " pair status :: " + pairCal(p2Cards));
            // System.out.println("~~ rejectedCardSet :: " + Arrays.toString(rejectedCardSet));
            System.out.println("----------------------------------------------");
            System.out.println("p1 turn starts here??????????????????????????????????????????????????? ");
            if (rejectedCardSet.length == 0) 
            {
                System.out.println("rejected card set is empty");
                randomCardp1 = cardSet[generateRandomNum(cardSet.length)];
                //System.out.println("p1 picked random card " + randomCardp1 + " from cardset");
               
                cardSet = remove(cardSet, randomCardp1);
                
                //System.out.println("random card " + randomCardp1 + " picked by p1 is removed from cardset ");
                // System.out.println(
                //         "cardset after removing random card " + randomCardp1 + " will be :: "
                //                 + Arrays.toString(cardSet));
                 accept = 0;
                 System.out.println("p1 cards :::"+Arrays.toString(p1Cards)+"pair :::"+pairCal(p1Cards)+" random card "+randomCardp1);
                System.out.println("player p1 please enter 1 or 0 in order to accept or reject card ::");
                accept = sc.nextInt();
                if (accept == 1) {
                   // System.out.println("p1 wants to accept card " + randomCardp1);

                    // System.out.println(
                    //         "~~ sorted_p1Cards  :: " + Arrays.toString(p1Cards) + " pair status :: "
                    //                 + pairCal(p1Cards)+" random card ::"+randomCardp1);
                    System.out.println("which card do u want to replace player p1 ? ::");
                    replaceCardp1 = sc.nextInt();

                    // System.out.println("player p1 wants to replace card " + replaceCardp1 + " from p1cards "
                    //         + Arrays.toString(p1Cards));
                    p1Cards = remove(p1Cards, replaceCardp1);
                    p1Cards = add(p1Cards, randomCardp1);
                    //System.out.println("p1 cards unsorted after replacement :: " + Arrays.toString(p1Cards));
                    p1Cards = sortCards(p1Cards);
                    if (pairCal(p1Cards)==3) {
                        break;
                    }
                    // System.out.println("p1 cards sorted after replacement :: " + Arrays.toString(p1Cards) + " pairs "
                    //         + pairCal(p1Cards));
                    // System.out.println(
                    //         "rejected cardsset before adding replacing card :: " + Arrays.toString(rejectedCardSet));
                    rejectedCardSet = add(rejectedCardSet, replaceCardp1);
                     rejectedCard=rejectedCardSet[rejectedCardSet.length-1];
                    // System.out.println(
                    //         "rejected cardsset after adding replacing card :: " + Arrays.toString(rejectedCardSet));
                    // System.out.println("p1 cards ::: "+Arrays.toString(p1Cards)+" pair :::"+pairCal(p1Cards));
                    // System.out.println("rejected cardset ::: "+Arrays.toString(rejectedCardSet));

                    System.out.println("cardSet         :: " + Arrays.toString(cardSet));
                    System.out.println("p1Cards         :: " + Arrays.toString(p1Cards)+" pair :: "+pairCal(p1Cards));
                    System.out.println("rejectedCardSet :: " + Arrays.toString(rejectedCardSet));

                } else {
                    // System.out.println("rejected cardset is not empty");
                    // // System.out.println("p1 wants to reject  card");
                    // System.out.println("rejected cardsset before rejecting random card by p1:: "
                    //         + Arrays.toString(rejectedCardSet));
                    rejectedCardSet = add(rejectedCardSet, randomCardp1);
                    rejectedCard=rejectedCardSet[rejectedCardSet.length-1];
                    // System.out.println("p1 cards ::: "+Arrays.toString(p1Cards)+" pair :::"+pairCal(p1Cards));
                    // System.out.println("rejected cardset  :: "
                    //         + Arrays.toString(rejectedCardSet));
                    System.out.println("cardSet         :: " + Arrays.toString(cardSet));
                    System.out.println("p1Cards         :: " + Arrays.toString(p1Cards)+" pair :: "+pairCal(p1Cards));
                    System.out.println("rejectedCardSet :: " + Arrays.toString(rejectedCardSet));

                }


            } else {
                 //CODE HERE P1 2ND ROUND
                 System.out.println("rejected cardset is not empty");
                //  System.out.println("p1 strts here 2nd");
                  rCardOrCardSetp1=0;
                 rejectedCard=rejectedCardSet[rejectedCardSet.length-1];
System.out.println("p1 cards ::: "+Arrays.toString(p1Cards)+" pair ::: "+pairCal(p1Cards)+" rejected card ::: "+rejectedCard);

                 System.out.println("please enter 1 or 2 in order to select card from rejected cardset or cardset respectively");
                 rCardOrCardSetp1=sc.nextInt();

                 if (rCardOrCardSetp1 == 1) //START HERE
            {
                rejectedCard=rejectedCardSet[rejectedCardSet.length-1];
                // System.out.println("player p1 wants to select card  rejected cardset ");
                // System.out.println("p1 cards :: " + Arrays.toString(p1Cards) + " pairs " + pairCal(p1Cards));
                // System.out.println("rejected cardset :: " + Arrays.toString(rejectedCardSet));
                // System.out.println("upper card from rejected cardset  :: " + rejectedCard);
                System.out.println("player p1 please enter which card do you want to replace");
                replaceCardp1 = sc.nextInt();

                p1Cards = remove(p1Cards, replaceCardp1);
                p1Cards = add(p1Cards, rejectedCard);
                p1Cards = sortCards(p1Cards);
                if (pairCal(p1Cards)==3) {
                    break;
                }
                rejectedCardSet = remove(rejectedCardSet, rejectedCard);
                rejectedCardSet = add(rejectedCardSet, replaceCardp1);  

                System.out.println("cardset          :: " +Arrays.toString(cardSet));
                System.out.println("p2 card          :: " + Arrays.toString(p2Cards) + " pair :" + pairCal(p2Cards));
                System.out.println("rejected cardset :: " + Arrays.toString(rejectedCardSet));

            } else
            {
                System.out.println("player p1 wants to select card   from cardset ");

                randomCardp1 = cardSet[generateRandomNum(cardSet.length)];
                //System.out.println("p1 picked random card " + randomCardp1 + " from cardset");
               
                cardSet = remove(cardSet, randomCardp1);
                if (cardSet.length==0) {
                    for (; rejectedCardSet.length!=0; ) {
                      int ele=rejectedCardSet[0];
                      rejectedCardSet=remove(rejectedCardSet, ele);
                      cardSet=add(cardSet, ele);
                    }
                  }
                // System.out.println("random card " + randomCardp1 + " picked by p1 is removed from cardset ");
                // System.out.println(
                //         "cardset after removing random card " + randomCardp1 + " will be :: "
                //                 + Arrays.toString(cardSet));
                 accept = 0;
                 System.out.println("p1Cards ::: "+Arrays.toString(p1Cards)+" pair :::"+pairCal(p1Cards)+" random card ::: "+randomCardp1);
                System.out.println("player p1 please enter 1 or 0 in order to accept or reject card ::");
                accept = sc.nextInt();

                if (accept == 1) {
                    //System.out.println("p1 wants to accept card " + randomCardp1);

                    // System.out.println(
                    //         "~~ sorted_p1Cards  :: " + Arrays.toString(p1Cards) + " pair status :: "
                    //                 + pairCal(p1Cards));
                    System.out.println("p1 cards ::: "+Arrays.toString(p1Cards)+" pair ::: "+pairCal(p1Cards)+" randomCard ::: "+randomCardp1);
                    System.out.println("which card do u want to replace player p1 ? ::");
                    replaceCardp1 = sc.nextInt();

                    // System.out.println("player p1 wants to replace card " + replaceCardp1 + " from p1cards "
                    //         + Arrays.toString(p1Cards));
                    p1Cards = remove(p1Cards, replaceCardp1);
                    p1Cards = add(p1Cards, randomCardp1);
                    // System.out.println("p1 cards unsorted after replacement :: " + Arrays.toString(p1Cards));
                    p1Cards = sortCards(p1Cards);
                    if (pairCal(p1Cards)==3) {
                        break;
                    }
                    // System.out.println("p1 cards sorted after replacement :: " + Arrays.toString(p1Cards) + " pairs "
                            // + pairCal(p1Cards));
                    // System.out.println(
                            // "rejected cardsset before adding replacing card :: " + Arrays.toString(rejectedCardSet));
                    rejectedCardSet = add(rejectedCardSet, replaceCardp1);
                    // System.out.println(
                    //         "rejected cardsset after adding replacing card :: " + Arrays.toString(rejectedCardSet));
   //         "rejected cardsset after adding replacing card :: " + Arrays.toString(rejectedCardSet));
   System.out.println("cardset          :: "+Arrays.toString(cardSet));
   System.out.println("p2 card          :: " + Arrays.toString(p2Cards) + " pair :" + pairCal(p2Cards));
   System.out.println("rejected cardset :: " + Arrays.toString(rejectedCardSet));
                } else {
                    System.out.println("p1 wants to reject  card");
                    System.out.println("rejected cardsset before rejecting random card by p1:: "
                            + Arrays.toString(rejectedCardSet));
                    rejectedCardSet = add(rejectedCardSet, randomCardp1);
                    System.out.println("rejected cardset after rejecting random card by p1 :: "
                            + Arrays.toString(rejectedCardSet));

                }
            }//ends HERE
            }
System.out.println("p1 turn ends here??????????????????????????????????????????????????????????????????");




































            System.out.println("p2 turn starts here??????????????????????????????????????????????????????????????????");
            System.out.println(
                    "player p2 please enter 1 or 2 to pick rejected randomcard by p1 or to pick random card from cardset  :");
            int replaceCardp2 = 0;
            rejectedCard=rejectedCardSet[rejectedCardSet.length-1];
            System.out.println("p2 cards ::: "+Arrays.toString(p2Cards)+" pair :::"+pairCal(p2Cards)+" rejected card ::: "+rejectedCard);
            int rCardOrCardSetp2 = sc.nextInt();
            int randomCardp2;

            if (rCardOrCardSetp2 == 1) //START HERE
            {
                
                // System.out.println("player p2 wants to select card  rejected cardset ");
                // System.out.println("p2 cards :: " + Arrays.toString(p2Cards) + " pairs " + pairCal(p2Cards));
                // System.out.println("rejected cardset :: " + Arrays.toString(rejectedCardSet));
                // System.out.println("upper card from rejected cardset  :: " + rejectedCard);
// System.out.println("p2 cards ::: "+Arrays.toString(p2Cards)+" pair :::"+pairCal(p2Cards)+" rejected card :::"+rejectedCard+" rejected card set :::"+Arrays.toString(rejectedCardSet));
                System.out.println("player p2 please enter which card do you want to replace");
                replaceCardp2 = sc.nextInt();

                p2Cards = remove(p2Cards, replaceCardp2);
                p2Cards = add(p2Cards, rejectedCard);
                p2Cards = sortCards(p2Cards);
                if (pairCal(p2Cards)==3) {
                    break;
                }
                rejectedCardSet = remove(rejectedCardSet, rejectedCard);
                rejectedCardSet = add(rejectedCardSet, replaceCardp2);

System.out.println("cardset          :: "+Arrays.toString(cardSet));
System.out.println("p2 card          :: " + Arrays.toString(p2Cards) + " pair :" + pairCal(p2Cards));
System.out.println("rejected cardset :: " + Arrays.toString(rejectedCardSet));
               
            } else
            {
                System.out.println("player p2 wants to select card   from cardset ");

                randomCardp2 = cardSet[generateRandomNum(cardSet.length)];
                // System.out.println("p2 picked random card " + randomCardp2 + " from cardset");
             
                cardSet = remove(cardSet, randomCardp2);
                if (cardSet.length==0) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~RESET DONE ON CARDSET AND REJECTED-CARDSET~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                    for (; rejectedCardSet.length!=0; ) {
                      int ele=rejectedCardSet[0];
                      rejectedCardSet=remove(rejectedCardSet, ele);
                      cardSet=add(cardSet, ele);
                    }
                  }
                // System.out.println("random card " + randomCardp2 + " picked by p2 is removed from cardset ");
                // System.out.println(
                //         "cardset after removing random card " + randomCardp2 + " will be :: "
                //                 + Arrays.toString(cardSet));
                int acceptp2 = 0;
                System.out.println("p1 cards :::"+Arrays.toString(p2Cards)+" pairs::: "+pairCal(p2Cards)+" randomcard::: "+randomCardp2);
                System.out.println("player p2 please enter 1 or in order to accept or reject card ::");
                acceptp2 = sc.nextInt();

                if (acceptp2 == 1) {
                    // System.out.println("p2 wants to accept card " + randomCardp2);

                    // System.out.println(
                    //         "~~ sorted_p2Cards  :: " + Arrays.toString(p2Cards) + " pair status :: "
                    //                 + pairCal(p1Cards));
                    System.out.println("which card do u want to replace player p2 ? ::");
                    replaceCardp2 = sc.nextInt();

                    // System.out.println("player p1 wants to replace card " + replaceCardp2 + " from p1cards "
                    //         + Arrays.toString(p2Cards));
                    p2Cards = remove(p2Cards, replaceCardp2);
                    p2Cards = add(p2Cards, randomCardp2);
                    // System.out.println("p2 cards unsorted after replacement :: " + Arrays.toString(p2Cards));
                    p2Cards = sortCards(p2Cards);
                    if (pairCal(p2Cards)==3) {
                        break;
                    }
                    // System.out.println("p2 cards sorted after replacement :: " + Arrays.toString(p2Cards) + " pairs "
                    //         + pairCal(p2Cards));
                    // System.out.println(
                    //         "rejected cardsset before adding replacing card :: " + Arrays.toString(rejectedCardSet));
                    rejectedCardSet = add(rejectedCardSet, replaceCardp2);
                    // System.out.println(
                    //         "rejected cardsset after adding replacing card :: " + Arrays.toString(rejectedCardSet));
                    System.out.println("cardset          :: "+Arrays.toString(cardSet));
                    System.out.println("p2 card          :: " + Arrays.toString(p2Cards) + " pair :" + pairCal(p2Cards));
                    System.out.println("rejected cardset :: " + Arrays.toString(rejectedCardSet));
                } else {
                    // System.out.println("p2 wants to reject  card");
                    // System.out.println("rejected cardsset before rejecting random card by p2:: "
                    //         + Arrays.toString(rejectedCardSet));
                    rejectedCardSet = add(rejectedCardSet, randomCardp2);
                    // System.out.println("rejected cardset after rejecting random card by p2 :: "
                    //         + Arrays.toString(rejectedCardSet));

                    System.out.println("cardset          :: "+Arrays.toString(cardSet));
                    System.out.println("p2 card          :: " + Arrays.toString(p2Cards) + " pair :" + pairCal(p2Cards));
                    System.out.println("rejected cardset :: " + Arrays.toString(rejectedCardSet));

                }
            }//ends HERE
            System.out.println("p2 turn ended here");

        
        
        
        
        
        
        
        
        
        
        
        }



    





















        if (pairCal(p1Cards) == 3) {
            System.out.println("p1 cards ::: "+Arrays.toString(p1Cards)+" pair status ::: "+pairCal(p1Cards));
            System.out.println("p1 win");
        } else if (pairCal(p2Cards) == 3) {
            System.out.println("p2 cards ::: "+Arrays.toString(p2Cards)+" pair status ::: "+pairCal(p2Cards));

            System.out.println("p2 win");
        }
        System.out.println("Game over...!");
System.out.println("please enter any number other than 0 if u want to play game again :::");
gameLoopVariable=sc.nextInt();
    }while(gameLoopVariable!=0);

    System.out.println("PLEASE REEXICUTE GAME PROGRAM..! PROGRAM IS TERMINATED");
    }

    // pair calculation
    static int pairCal(int arr[]) {
        int pairCount = 0;
        for (int i = 0; i < arr.length; i += 2) {
            if (next4smultiple(arr[i]) == next4smultiple(arr[i + 1])) {
                pairCount++;
            } else if (arr[i] >= 41 && arr[i] <= 44) {
                pairCount++;
            }
        }
        // System.out.println("pair_count ::" + pairCount);
        return pairCount;
    }

    // next 4's multiple
    static int next4smultiple(int num) {

        for (;;) {
            if (num % 4 == 0) {
                // System.out.println("nxt 4s multiple::"+num);
                return num;

            } else {
                num++;
            }
        }
    }

    // sorting cards
    static int[] sortCards(int arr[]) {
        if (f1f4Count(arr) == 3) {
            arr = f1f4Count3arr(arr);
            return arr;
        }
        int refArr1[] = new int[arr.length];
        for (int i = 0; i < refArr1.length; i++) {
            if (arr[i] >= 1 && arr[i] <= 4) {
                refArr1[i] = 1;
            } else if (arr[i] >= 5 && arr[i] <= 8) {
                refArr1[i] = 2;
            } else if (arr[i] >= 9 && arr[i] <= 12) {
                refArr1[i] = 3;
            } else if (arr[i] >= 13 && arr[i] <= 16) {
                refArr1[i] = 4;
            } else if (arr[i] >= 17 && arr[i] <= 20) {
                refArr1[i] = 5;
            } else if (arr[i] >= 21 && arr[i] <= 24) {
                refArr1[i] = 6;
            } else if (arr[i] >= 25 && arr[i] <= 28) {
                refArr1[i] = 7;
            } else if (arr[i] >= 29 && arr[i] <= 32) {
                refArr1[i] = 8;
            } else if (arr[i] >= 33 && arr[i] <= 36) {
                refArr1[i] = 9;
            } else if (arr[i] >= 37 && arr[i] <= 40) {
                refArr1[i] = 10;
            } else if (arr[i] >= 41 && arr[i] <= 44) {
                refArr1[i] = 11;
            }

            else if (arr[i] >= 45 && arr[i] <= 48) {
                refArr1[i] = 12;
            } else {
                refArr1[i] = 13;
            }
        }

        // System.out.println("initial refrence array m1:: "+Arrays.toString(refArr1));

        for (int i = 0; i + 1 < refArr1.length - 2; i++) {
            for (int j = i + 1; j < refArr1.length; j++) {

                if ((refArr1[i] == refArr1[j])) {

                    int temp;
                    temp = refArr1[i + 1];
                    refArr1[i + 1] = refArr1[j];
                    refArr1[j] = temp;

                    int temp2;
                    temp2 = arr[i + 1];
                    arr[i + 1] = arr[j];
                    arr[j] = temp2;

                    i++;

                }
            }
        }
        // System.out.println("refrence array m2 pairing similar cards::
        // "+Arrays.toString(refArr1));
        // System.out.println("original array with m2 modification of refrence array(
        // pairing similar cards):: "+Arrays.toString(arr));
        for (int i = 0; i + 1 < refArr1.length; i++) {

            if ((refArr1[i] == refArr1[i + 1]) && (refArr1[i] != 11)) {
                refArr1[i] = 0;
                refArr1[i + 1] = 0;

            }
        }

        // System.out.println("refrence array m3(assigning 0 to all paired element)::
        // "+Arrays.toString(refArr1));
        // System.out.println(Arrays.toString(arr));

        int sortedArr[] = new int[0];
        for (int i = 0, j = 0; i < refArr1.length; i++) {
            if (refArr1[i] == 0) {
                sortedArr = add(sortedArr, arr[i]);
            }
        }

        // System.out.println("sorted array created using m3 refrence ::" +
        // Arrays.toString(sortedArr));

        int unSortedArr[] = new int[0];
        for (int i = 0, j = 0; i < refArr1.length; i++) {
            if (refArr1[i] != 0) {
                unSortedArr = add(unSortedArr, arr[i]);
            }
        }
        // System.out.println("unsorted array created using m3 refrence ::" +
        // Arrays.toString(unSortedArr));
        for (int i = 0, j = unSortedArr.length - 1; i < j; i++) {
            if (unSortedArr[i] >= 41 && unSortedArr[i] <= 44) {
                int temp = unSortedArr[i];
                unSortedArr[i] = unSortedArr[j];
                unSortedArr[j] = temp;
                j--;
            }
        }

        // System.out.println("modified1 unsorted array, all 41-44 element at ending ::
        // " + Arrays.toString(unSortedArr));

        for (int i = 0, j = unSortedArr.length - 1; i < unSortedArr.length - 1 && j > 0; j--, i += 2) {
            if (unSortedArr[j] < 41 && unSortedArr[j] > 44) {
                j--;
                continue;
            }

            int temp = unSortedArr[i];
            unSortedArr[i] = unSortedArr[j];
            unSortedArr[j] = temp;

        }

        // System.out.println("modified2 unsorted array, all 41-44 element at
        // endinpaired from intial positiong ::" +Arrays.toString(unSortedArr));

        for (int i = 0; i < unSortedArr.length; i++) {
            sortedArr = add(sortedArr, unSortedArr[i]);
        }

        // System.out.println("sorted array final::" + Arrays.toString(sortedArr));

        return sortedArr;

    }

    // 41-44 count
    static int f1f4Count(int arr[]) {
        int f1f4count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 41 && arr[i] <= 44) {
                f1f4count++;
            }
        }
        return f1f4count;
    }

    static int[] f1f4Count3arr(int arr[]) {

        for (int i = 0, j = arr.length - 1; i < j; i++) {
            if (arr[i] >= 41 && arr[i] <= 44) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        // System.out.println(" array 41-44 3 times::" + Arrays.toString(arr));

        for (int i = 0, j = arr.length - 1; j > 0 && i < arr.length - 1; j--, i += 2) {
            arr[j] = arr[j] + arr[i];
            arr[i] = arr[j] - arr[i];
            arr[j] = arr[j] - arr[i];
            // System.out.println(" array 41-44 3 times final in lopp::" +
            // Arrays.toString(arr));
        }
        // System.out.println(" array 41-44 3 times final ::" + Arrays.toString(arr));

        return arr;
    }

    // OriginalSet
    static int[] OriginalSet() {
        int modifiedArr[] = new int[52];

        for (int i = 0; i < modifiedArr.length; i++) {
            modifiedArr[i] = i + 1;
        }
        return modifiedArr;
    }

    // remove element from array
    static int[] remove(int arr[], int element) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                break;
            }
        }

        arr[i] = arr[i] + arr[arr.length - 1];
        arr[arr.length - 1] = arr[i] - arr[arr.length - 1];
        arr[i] = arr[i] - arr[arr.length - 1];

        int modifiedArr[] = new int[arr.length - 1];

        for (int j = 0; j < modifiedArr.length; j++) {
            modifiedArr[j] = arr[j];
        }
        return modifiedArr;

    }

    // add element to array
    static int[] add(int arr[], int element) {

        int modifiedArr[] = new int[arr.length + 1];

        for (int i = 0; i < modifiedArr.length - 1; i++) {
            modifiedArr[i] = arr[i];
        }
        modifiedArr[modifiedArr.length - 1] = element;

        return modifiedArr;

    }

    // code for shuffling array elements
    static int[] shuffle(int arr[]) {
        int random_index1, random_index2;
        int modifiedArr[] = new int[arr.length];

        for (int i = 0; i < modifiedArr.length; i++) {
            modifiedArr[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {

            random_index1 = generateRandomNum(arr.length);
            random_index2 = generateRandomNum(arr.length);

            if (random_index1 == random_index2) {
                continue;
            }

            modifiedArr[random_index1] = modifiedArr[random_index1] + modifiedArr[random_index2];
            modifiedArr[random_index2] = modifiedArr[random_index1] - modifiedArr[random_index2];
            modifiedArr[random_index1] = modifiedArr[random_index1] - modifiedArr[random_index2];

        }

        return modifiedArr;

    }

    // generating random number between 1 to limit-1
    static int generateRandomNum(int limit) {

        return (int) (Math.random() * 100 % limit);

    }

}
