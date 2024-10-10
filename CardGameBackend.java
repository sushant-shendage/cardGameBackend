
import java.util.Arrays;
import java.util.Scanner;

public class CardGameBackend {
    public static void main(String[] args) {
        int cardBundle[] = new int[52];

        for (int i = 0; i < cardBundle.length; i++) {
            cardBundle[i] = i + 1;
        }

        int player1Cards[] = new int[1], player2Cards[] = new int[1];

        // code for ::SHUFFLING AND CARD DISTRIBUTION AMONG PLAYERS ::starts
        // here----------------------------------------------------------------
        int randomElement = 0;
        for (int i = 1; i <= 5; i++) {
            randomElement = cardBundle[generateRandomLessThan(cardBundle.length)];
            player1Cards = addAEle(player1Cards, randomElement);
            cardBundle = removeAEle(cardBundle, randomElement);

            randomElement = cardBundle[generateRandomLessThan(cardBundle.length)];
            player2Cards = addAEle(player2Cards, randomElement);
            cardBundle = removeAEle(cardBundle, randomElement);
        }
        player1Cards = removeAEle(player1Cards, 0);
        player2Cards = removeAEle(player2Cards, 0);

        randomElement = cardBundle[generateRandomLessThan(cardBundle.length)];
        player1Cards = addAEle(player1Cards, randomElement);
        cardBundle = removeAEle(cardBundle, randomElement);

        randomElement = cardBundle[generateRandomLessThan(cardBundle.length)];
        player2Cards = addAEle(player2Cards, randomElement);
        cardBundle = removeAEle(cardBundle, randomElement);

        // Arrays.sort(player1Cards);
        // Arrays.sort(player2Cards);

        System.out.println("  cardBundle    :: " + Arrays.toString(cardBundle) + "      cardBundleSize    :: "
                + cardBundle.length);
        System.out.println("  player1Cards  :: " + Arrays.toString(player1Cards) + "    player1CardsSize  :: "
                + player1Cards.length);
        System.out.println("  player2Cards  :: " + Arrays.toString(player2Cards) + "    player2CardsSize  :: "
                + player2Cards.length);

        player1Cards = sortCardsAndPairStatus(player1Cards);
        System.out.println("player1 sorted cards ::" + Arrays.toString(player1Cards));

        player2Cards = sortCardsAndPairStatus(player2Cards);
        System.out.println("player2 sorted cards ::" + Arrays.toString(player2Cards));

        // code for ::SHUFFLING AND CARD DISTRIBUTION AMONG PLAYERS ::ends
        // here------------------------------------------------------------------

       gamePlay(cardBundle, player1Cards, player2Cards);
       //GAME FAILED ...!

       
    }

    static void gamePlay(int main[], int sub1[], int sub2[]) {
        Scanner sc = new Scanner(System.in);
        int rejectedCardSet[] = new int[1];
        System.out.println("main                       ::" + Arrays.toString(main));
        System.out.println("sub1                       ::" + Arrays.toString(sub1));
        System.out.println("sub2                       ::" + Arrays.toString(sub2));
        System.out.println("rejected card set          ::" + Arrays.toString(rejectedCardSet));

        int replaceCard=0;
        int randomCardP1 = main[generateRandomLessThan(main.length)];
        System.out.println("random card selected by p1 ::" + randomCardP1);

        int accept = 0;
        System.out.print("p1:please enter 0 to reject and 1 to accept card ::");
        accept = sc.nextInt();

        while (true) {
            if (accept == 1 || accept == 0) {
                break;
            } else {
                System.out.println("please give inputs as per instructions");
                System.out.print("p1:please enter 0 to reject and 1 to accept card ::");
                accept = sc.nextInt();
            }
        }

        if (accept == 1) {
            System.err.println();
            System.out.println("p1 accepted card");
            System.out.println("sub1                       ::" + Arrays.toString(sub1));
            System.out.print("Enter which card do u want to replace ::");
            replaceCard=sc.nextInt();

            sub1=removeAEle(sub1, randomCardP1);
            System.out.println("sub1                       ::" + Arrays.toString(sub1));

            // sub1=addAEle(sub1, replaceCard);
            // System.out.println("sub1                       ::" + Arrays.toString(sub1));
             


        } else {
            System.out.println("p1 rejected card");
        }

    }

    static int[] rangeToRightSideOfArr(int arr[]) {
        for (int i = 0, j = arr.length - 1; i < j; i++) {
            if (arr[i] >= 41 && arr[i] <= 44) {
                if (arr[j] >= 41 && arr[j] <= 44) {
                    j--;

                }
                // System.out.println("yes");
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];

                j--;

            }
        }
        int present2;
        do {
            present2 = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if ((arr[i] >= 41 && arr[i] <= 44) && (arr[i + 1] < 41 && arr[i + 1] > 44)) {
                    i++;
                    continue;
                }
                if ((arr[i] < 41 && arr[i] > 44) && (arr[i + 1] >= 41 && arr[i + 1] <= 44)) {
                    System.out.println("yes2");
                    arr[i] = arr[i] + arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] = arr[i] - arr[i + 1];
                    present2 = 1;
                    // System.out.println("41-44 to right side ::"+Arrays.toString(arr));
                    break;
                }
            }

        } while (present2 != 0);
        // System.out.println("41-44 to right side ::"+Arrays.toString(arr));
        return arr;
    }

    static int[] removeAllOccOfAEleInarr(int arr[], int element) {
        int present = 0;
        do {
            present = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == element) {
                    present = 1;
                    arr = removeAEle(arr, element);
                    break;
                }

            }

        } while (present > 0);

        // System.out.println(Arrays.toString(arr));

        return arr;

    }

    static int[] sortCardsAndPairStatus(int arr[]) {
        int refArr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 1 && arr[i] <= 4) {
                refArr[i] = 1;
            } else if (arr[i] >= 5 && arr[i] <= 8) {
                refArr[i] = 2;
            } else if (arr[i] >= 9 && arr[i] <= 12) {
                refArr[i] = 3;
            } else if (arr[i] >= 11 && arr[i] <= 16) {
                refArr[i] = 4;
            } else if (arr[i] >= 17 && arr[i] <= 20) {
                refArr[i] = 5;
            } else if (arr[i] >= 21 && arr[i] <= 24) {
                refArr[i] = 6;
            } else if (arr[i] >= 25 && arr[i] <= 28) {
                refArr[i] = 7;
            } else if (arr[i] >= 29 && arr[i] <= 32) {
                refArr[i] = 8;
            } else if (arr[i] >= 30 && arr[i] <= 36) {
                refArr[i] = 9;
            } else if (arr[i] >= 37 && arr[i] <= 40) {
                refArr[i] = 10;
            } else if (arr[i] >= 41 && arr[i] <= 44) {
                refArr[i] = 11;
            } else if (arr[i] >= 45 && arr[i] <= 48) {
                refArr[i] = 12;
            } else if (arr[i] >= 49 && arr[i] <= 52) {
                refArr[i] = 13;
            }

        }

        // System.out.println("before operations : "+Arrays.toString(refArr));

        for (int i = 0; i + 1 <= 3; i++) {
            if (refArr[i] == refArr[i + 1]) {
                continue;
            }
            for (int j = i + 1; j < refArr.length; j++) {
                if (refArr[i] == refArr[j]) {
                    System.out.println();
                    refArr[i + 1] = refArr[i + 1] + refArr[j];
                    refArr[j] = refArr[i + 1] - refArr[j];
                    refArr[i + 1] = refArr[i + 1] - refArr[j];

                    arr[i + 1] = arr[i + 1] + arr[j];
                    arr[j] = arr[i + 1] - arr[j];
                    arr[i + 1] = arr[i + 1] - arr[j];
                    i++;
                }
            }
        }

        // System.out.println("after operations : "+Arrays.toString(refArr));
        // System.out.println("after operations cards array : "+Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr));

        // sorted cards addition

        int refArr2[] = new int[arr.length];
        int arr2[] = new int[arr.length];

        for (int i = 0, j = 0; i < refArr2.length - 1; i++) {
            if (refArr[i] == refArr[i + 1]) {
                refArr2[j] = refArr[i];
                arr2[j] = arr[i];
                arr[i] = 0;
                j++;
                refArr2[j] = refArr[i + 1];
                arr2[j] = arr[i + 1];
                arr[i + 1] = 0;
                j++;
                i++;
            }

        }

        // System.out.println("ref arr2 :: " + Arrays.toString(refArr2));
        arr = removeAllOccOfAEleInarr(arr, 0);
        arr = rangeToRightSideOfArr(arr);
        int UnsortedCards = arr.length;

        int sortedCardsNumber = (refArr.length - UnsortedCards);
        // System.out.println("sortedCards::" + sortedCardsNumber / 2);
        // System.out.println("arr ::" + Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr2));

        for (int i = 0, j = arr2.length - 1; i < arr.length; i++) {
            arr2[j] = arr[i];
            j--;
        }
        // System.out.println("sorted cards " + Arrays.toString(arr2));

        int additionalCount = 0;
        for (int i = sortedCardsNumber; i < arr2.length; i++) {
            if (arr2[i] == 41 || arr2[i] == 42 || arr2[i] == 43 || arr2[i] == 44) {

                additionalCount++;
            }
        }
        additionalCount += sortedCardsNumber / 2;
        System.out.println("additionalCount ::" + additionalCount);

        // if (additionalCount==3 && loopCount==1) {

        // }

        // System.out.println("fx completed");
        return arr2;

    }

    static int generateRandomLessThan(int num) {
        return (int) (Math.random() * 10);
    }

    static int[] removeAEle(int arr[], int element) {
        int modifiedArr[] = new int[arr.length - 1];

        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                break;
            }
        }

        System.out.println("before swap  arr[i] ::"+arr[i]+"arr[arr.length-1] ::"+arr[arr.length-1]);
        arr[i] = arr[i] + arr[arr.length - 1];
        arr[arr.length - 1] = arr[i] - arr[arr.length - 1];
        arr[i] = arr[i] - arr[arr.length - 1];
        System.out.println("after swap  arr[i] ::"+arr[i]+"arr[arr.length-1] ::"+arr[arr.length-1]);

        for (int j = 0; j < modifiedArr.length; j++) {
            modifiedArr[j] = arr[j];
        }

        return modifiedArr;
    }

    static int[] addAEle(int arr[], int element) {
        int modifiedArr[] = new int[arr.length + 1];
        for (int i = 0; i < modifiedArr.length - 1; i++) {
            modifiedArr[i] = arr[i];
        }
        modifiedArr[modifiedArr.length - 1] = element;
        return modifiedArr;

    }

}
