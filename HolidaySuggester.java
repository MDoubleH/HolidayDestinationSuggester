import java.util.Scanner;

public class HolidaySuggester {
    public static Scanner sc = new Scanner(System.in);

    public static boolean askYesNo(String question) {
        String answer = sc.nextLine(); //Read user's answer
        return answer.equals("y"); //If input = "y", return true, else false
    }

    public static void main(String[] args) {

        // Build tree with asking [y/n]
        TreeNode root = new TreeNode("Do you like cold weather?", //Root Node
                new TreeNode("Are you a keen hiker?", //Left Subtree
                        new TreeNode("the Scottish Highlands"), //Left left
                        new TreeNode("Moscow")), //Left right
                new TreeNode("Goa")); //Right leaf

        //Intro messages
        System.out.println("Welcome to the Post-Covid Holiday Destination Suggester!");
        TreeNode current = root; //Start at root
        String playAgain = "Do you want to play again? [y/n]";
        String isSatisfactory = "Is this satisfactory? [y/n]";

        while (current.value != null) { //While current node isn't null, play
            System.out.println(current.value + "[y/n]");  //Print the current node and [y/n] with it

            if (askYesNo(current.value)){ //If user answers yes, get left
                current = current.getLeft();
            }else{
                current = current.getRight(); //If no, get right
            }

            if (current.isLeaf()){ //If reached a leaf, print the suggestion
                System.out.println(current.value);
                System.out.println(isSatisfactory);//See if suggestion is satisfactory
                if (askYesNo(isSatisfactory)){ //If satisfactory play again!
                    System.out.println(playAgain);
                    if (askYesNo(playAgain)){
                        current = root;
                    }
                    else{
                        break;
                    }
                }
                //Else if suggestion bad, add new question and suggestion from user
                else{
                    System.out.println("What would you prefer instead?");
                    String userSuggestion = sc.nextLine();

                    System.out.println("Tell me a question that distinguishes " + current.value + " from " + userSuggestion);
                    String userQuestion = sc.nextLine();

                    TreeNode oldNode = new TreeNode(current.value, null, null);
                    TreeNode userSug = new TreeNode(userSuggestion, null, null);
                    current.right = oldNode; //Make current node point to the old node
                    current.left = userSug; //Have left node be the new user suggestion node
                    current.value = userQuestion;
                    System.out.println(playAgain);
                    if (askYesNo(playAgain)){
                        current = root;
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }
}

