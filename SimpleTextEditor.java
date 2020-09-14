package dsalg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author nmorla
 * @since Aug 27, 2020
 */
public class SimpleTextEditor {

    public static void main(String[] args) throws Exception {
//        solution1();
//        solution2();
//        solution3();
//        solution4();
        solution6();

        /*
        Sample code to compute execution time.
         */
        //140 ms
        long lStartTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            String newStr = "Hai hello" + i + "My God";
        }
        long lEndTime = System.nanoTime();
        System.out.println("Time taken (String Addition):: " + (lEndTime - lStartTime) / 1000000);
        lStartTime = System.nanoTime();
        String newStr = "Hai hello" + lStartTime + "My God";
        // 20 ms
        for (int i = 0; i < 1000000; i++) {
            String subStr = newStr.substring(3, 10);
        }
        lEndTime = System.nanoTime();
        System.out.println("Time taken (Sub String):: " + (lEndTime - lStartTime) / 1000000);
        lStartTime = System.nanoTime();
        StackWithArray<Integer> startPosition = new StackWithArray<>(100);
        // 40 ms
        for (int i = 0; i < 1000000; i++) {
            startPosition.push(i);
        }
        lEndTime = System.nanoTime();
        System.out.println("Time taken (Stack Push):: " + (lEndTime - lStartTime) / 1000000);
        lStartTime = System.nanoTime();
        // 55 ms
        for (int i = 0; i < 1000000; i++) {
            new StringBuilder("Hello" + i);
        }
        lEndTime = System.nanoTime();
        System.out.println("Time taken (Builder Creation):: " + (lEndTime - lStartTime) / 1000000);
        lStartTime = System.nanoTime();
        // 55 ms
        for (int i = 0; i < 1000000; i++) {
            Integer.parseInt("43123");
        }
        lEndTime = System.nanoTime();
        System.out.println("Time taken (Parse Int):: " + (lEndTime - lStartTime) / 1000000);
        int into = "4 567567".charAt(0);
        System.out.println("char to int :: " + into);
    }

//    private static void solution6() throws Exception {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        StringBuilder sb = new StringBuilder(1000000 + 16);
//        StackWithArray<Integer> startPosition = new StackWithArray<>(n);
//        StackWithArray<Integer> endPosition = new StackWithArray<>(n);
//        startPosition.push(0);
//        endPosition.push(-1);
//        for (int i = 0; i < n; i++) {
//            int choice = sc.nextInt();
//            switch (choice) {
//                case 1:
//                    String val = sc.next();
////                    System.out.println("============ push [" + val + "]");
//                    Integer prev = endPosition.peek();
//                    sb.append(val);
//                    endPosition.push(prev + val.length());
//                    startPosition.push(startPosition.peek());
//                    break;
//
//                case 2:
//                    int charsToDelete = sc.nextInt();
////                    Integer prevDel = startPosition.peek();
////                    endPosition.push(endPosition.peek());
////                    startPosition.push(prevDel + charsToDelete);
//                    endPosition.push(endPosition.peek() - charsToDelete);
//                    startPosition.push(startPosition.peek());
////      System.out.println("============= Del " + charsToDelete + " [" + Arrays.toString(editorContent.getElements()) + "]");
//                    break;
//
//                case 3:
//                    int charsToDisp = sc.nextInt();
////                    System.out.println("========= Disp [" + Arrays.toString(editorContent.getElements()) + "]");
//                    Integer prevDisp = startPosition.peek();
//                    System.out.println(sb.charAt((charsToDisp + prevDisp) - 1));
//                    break;
//
//                case 4:
//                    startPosition.pop();
//                    endPosition.pop();
////                    System.out.println("4 ================ Prev Choice[" + lastUserChoice + "], Prev Str:[" + lastImpact + "], "
////                            + "Content:[" + Arrays.toString(editorContent.getElements()) + "]");
//                    break;
//
//                default:
//                    System.out.println("Wrong Choice");
//            }
//        }
//        sc.close();
//    }
    private static void solution6() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StackWithArray<String> editorContent = new StackWithArray<>(n);
        editorContent.push("");
        for (int i = 0; i < n; i++) {
            String nextLine = br.readLine();
            int choice = nextLine.charAt(0) - 48;
            switch (choice) {
                case 1:
                    String val = nextLine.substring(2);
                    System.out.println("============ push [" + val + "]");
                    String prev = editorContent.peek();
                    editorContent.push(prev + val);
                    break;

                case 2:
                    int charsToDelete = Integer.parseInt(nextLine.substring(2));
                    String prevDel = editorContent.peek();
                    editorContent.push(prevDel.substring(0, prevDel.length() - charsToDelete));
//      System.out.println("============= Del " + charsToDelete + " [" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                case 3:
                    int charsToDisp = Integer.parseInt(nextLine.substring(2));
//                    System.out.println("========= Disp [" + Arrays.toString(editorContent.getElements()) + "]");
                    String prevDisp = editorContent.peek();
                    System.out.println(prevDisp.charAt(charsToDisp - 1));
                    break;

                case 4:
                    editorContent.pop();
//                    System.out.println("4 ================ Prev Choice[" + lastUserChoice + "], Prev Str:[" + lastImpact + "], "
//                            + "Content:[" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
        br.close();
    }

    private static void solution5() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackWithArray<String> editorContent = new StackWithArray<>(n);
        editorContent.push("");
        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    String val = sc.next();
//                    System.out.println("============ push [" + val + "]");
                    String prev = editorContent.peek();
                    editorContent.push(prev + val);
                    break;

                case 2:
                    int charsToDelete = sc.nextInt();
                    String prevDel = editorContent.peek();
                    editorContent.push(prevDel.substring(0, prevDel.length() - charsToDelete));
//      System.out.println("============= Del " + charsToDelete + " [" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                case 3:
                    int charsToDisp = sc.nextInt();
//                    System.out.println("========= Disp [" + Arrays.toString(editorContent.getElements()) + "]");
                    String prevDisp = editorContent.peek();
                    System.out.println(prevDisp.charAt(charsToDisp - 1));
                    break;

                case 4:
                    editorContent.pop();
//                    System.out.println("4 ================ Prev Choice[" + lastUserChoice + "], Prev Str:[" + lastImpact + "], "
//                            + "Content:[" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
        sc.close();
    }

    private static void solution4() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackWithArray<String> impactStr = new StackWithArray<>(n / 2);
        StackWithArray<Integer> userChoices = new StackWithArray<>(n / 2);
        StackWithArray<Integer> impactStrLen = new StackWithArray<>(n / 2);
//        StackWithArray<Character> editorContent = new StackWithArray<>(n);
        int editorContentLen = 0;
        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    String val = sc.next();
//                    System.out.println("============ push [" + val + "]");
                    editorContentLen += val.length();
                    impactStr.push(val);
                    userChoices.push(choice);
                    impactStrLen.push(val.length());
                    break;

                case 2:
                    int charsToDelete = sc.nextInt();
                    editorContentLen -= charsToDelete;
                    userChoices.push(choice);
                    impactStrLen.push(charsToDelete);
                    impactStr.push(null);
//      System.out.println("============= Del " + charsToDelete + " [" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                case 3:
                    int charsToDisp = sc.nextInt();
//                    System.out.println("========= Disp [" + Arrays.toString(editorContent.getElements()) + "]");
                    int traversals = (editorContentLen - charsToDisp) + 1;
                    char c = solution4ComputeDataFromBack(userChoices, impactStrLen, impactStr, editorContentLen, traversals);
                    System.out.println(c);
                    break;

                case 4:
                    //tricky
                    int lastUserChoice = userChoices.pop();
                    int userDelStrLen = impactStrLen.pop();
                    String lastImpact = impactStr.pop();
                    if (lastUserChoice == 2) {
                        editorContentLen += userDelStrLen;
                        //User deleted some content, add it back.
                    } else {
                        editorContentLen -= userDelStrLen;
                    }
//                    System.out.println("4 ================ Prev Choice[" + lastUserChoice + "], Prev Str:[" + lastImpact + "], "
//                            + "Content:[" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
        sc.close();
    }

    private static char solution4ComputeDataFromBack(StackWithArray<Integer> userChoices, StackWithArray<Integer> impactStrLen, StackWithArray<String> impactStr, int editorContentLen, int traversals) throws Exception {
        int iteration = 1;
        int bal = 0;
        while (true) {
            int choice = userChoices.getElementFromTop(iteration);
            int strLen = impactStrLen.getElementFromTop(iteration);
            if (choice == 2) {
                bal -= strLen;
            } else {
                String str = impactStr.getElementFromTop(iteration);
                if (bal < 0 && strLen < (-1) * bal) {
                    bal += strLen;
                } else {
                    bal += strLen;
                    if (bal >= traversals) {
                        return str.toCharArray()[bal - traversals];
                    }
                }
            }
            ++iteration;
        }
    }

    private static void solution3() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackWithArray<String> impactStr = new StackWithArray<>(n / 2);
        StackWithArray<Integer> userChoices = new StackWithArray<>(n / 2);
        StackWithArray<Integer> impactStrLen = new StackWithArray<>(n / 2);
//        StackWithArray<Character> editorContent = new StackWithArray<>(n);
        int editorContentLen = 0;
        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    String val = sc.next();
//                    System.out.println("============ push [" + val + "]");
                    editorContentLen += val.length();
                    impactStr.push(val);
                    userChoices.push(choice);
                    impactStrLen.push(val.length());
                    break;

                case 2:
                    int charsToDelete = sc.nextInt();
                    editorContentLen -= charsToDelete;
                    userChoices.push(choice);
                    impactStrLen.push(charsToDelete);
                    impactStr.push(null);
//      System.out.println("============= Del " + charsToDelete + " [" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                case 3:
                    int charsToDisp = sc.nextInt();
//                    System.out.println("========= Disp [" + Arrays.toString(editorContent.getElements()) + "]");
                    int traversals = (editorContentLen - charsToDisp) + 1;
                    char[] ch = new char[editorContentLen];
                    solution3ComputeData(userChoices, impactStrLen, impactStr, ch, editorContentLen, traversals);
                    System.out.println(ch[ch.length - traversals]);
                    break;

                case 4:
                    //tricky
                    int lastUserChoice = userChoices.pop();
                    int userDelStrLen = impactStrLen.pop();
                    String lastImpact = impactStr.pop();
                    if (lastUserChoice == 2) {
                        editorContentLen += userDelStrLen;
                        //User deleted some content, add it back.
                    } else {
                        editorContentLen -= userDelStrLen;
                    }
//                    System.out.println("4 ================ Prev Choice[" + lastUserChoice + "], Prev Str:[" + lastImpact + "], "
//                            + "Content:[" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
        sc.close();
    }

    private static void solution3ComputeData(StackWithArray<Integer> userChoices, StackWithArray<Integer> impactStrLen, StackWithArray<String> impactStr, char[] ch, int editorContentLen, int traversals) throws Exception {
        int iteration = 1;
        int bal = 0;
        while (true) {
            int lchoice = userChoices.getElementFromTop(iteration);
            int im = impactStrLen.getElementFromTop(iteration);
            if (lchoice == 2) {
                bal -= im;
            } else {
                String dd = impactStr.getElementFromTop(iteration);
                if (bal < 0 && im < (-1) * bal) {
                    bal += im;
                } else {
                    bal += im;
                    System.arraycopy(dd.toCharArray(), 0, ch, editorContentLen - (bal), Math.min(im, bal));
                    if (bal >= traversals) {
                        break;
                    }
                }
            }
            ++iteration;
        }
    }

    private static void solution2() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackWithArray<String> impactStr = new StackWithArray<>(n / 2);
        StackWithArray<Integer> userChoices = new StackWithArray<>(n / 2);
        StackWithArray<Character> editorContent = new StackWithArray<>(1000000);
        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    String val = sc.next();
//                    System.out.println("============ push [" + val + "]");
                    int strLen = val.length();
                    for (int j = 0; j < strLen; j++) {
                        editorContent.push(val.charAt(j));
                    }
                    impactStr.push(val);
                    userChoices.push(choice);
                    break;

                case 2:
                    int charsToDelete = sc.nextInt();
                    userChoices.push(choice);
                    char[] ch = new char[charsToDelete];
                    for (int j = charsToDelete - 1; j >= 0; j--) {
                        ch[j] = editorContent.pop();
                    }
                    impactStr.push(new String(ch));
//                    System.out.println("============= Del " + charsToDelete + " [" + Arrays.toString(editorContent.getElements()) + "]");
                    break;

                case 3:
                    int charsToDisp = sc.nextInt();
//                    System.out.println("========= Disp [" + Arrays.toString(editorContent.getElements()) + "]");
                    System.out.println(editorContent.getElementFromBottom(charsToDisp));
                    break;

                case 4:
                    //tricky
                    int lastUserChoice = userChoices.pop();
                    String lastImpact = impactStr.pop();
//                    System.out.println("4 ================ Prev Choice[" + lastUserChoice + "], Prev Str:[" + lastImpact + "], "
//                            + "Content:[" + Arrays.toString(editorContent.getElements()) + "]");
                    if (lastUserChoice == 1) {
                        //String was added, now delete "lastImpact" from "content"
                        editorContent.deleteTop(lastImpact.length());
                    } else {
                        //String was deleted, add "lastImpact" back to "content"
                        int len = lastImpact.length();
                        for (int j = 0; j < len; j++) {
                            editorContent.push(lastImpact.charAt(j));
                        }
//                        editorContent.append(lastImpact);
                    }
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
        sc.close();
    }

    private static void solution1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackWithArray<String> impactStr = new StackWithArray<>(n / 2);
        StackWithArray<Integer> userChoices = new StackWithArray<>(n / 2);
        StringBuilder content = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    String val = sc.next();
//                    System.out.println("============ push [" + val + "]");
                    content.append(val);
                    impactStr.push(val);
                    userChoices.push(choice);
                    break;

                case 2:
                    int charsToDelete = sc.nextInt();
                    impactStr.push(content.substring(content.length() - charsToDelete));
                    userChoices.push(choice);
                    content.delete(content.length() - charsToDelete, content.length());
//                    System.out.println("============= Del " + charsToDelete + " [" + content + "]");
                    break;

                case 3:
                    int charsToDisp = sc.nextInt();
//                    System.out.println("========= Disp [" + content + "]");
                    System.out.println(content.charAt(charsToDisp - 1));
                    break;

                case 4:
                    //tricky
                    int lastUserChoice = userChoices.pop();
                    String lastImpact = impactStr.pop();
//                    System.out.println("4 ================ Prev Choice[" + lastUserChoice + "], Prev Str:[" + lastImpact + "], Content:[" + content + "]");
                    if (lastUserChoice == 1) {
                        //String was added, now delete "lastImpact" from "content"
                        content.delete(content.length() - lastImpact.length(), content.length());
                    } else {
                        //String was deleted, add "lastImpact" back to "content"
                        content.append(lastImpact);
                    }
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
        sc.close();
    }

}
