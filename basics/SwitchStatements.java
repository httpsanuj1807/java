class SwitchStatements {
    

    public static void main(String[] args){ 
        
        int n = 1;
		
		// switch(n){  // older version, similar to c++

        //     case 1:
        //         System.out.println("One");
        //         break;
        //     case 2:
        //         System.out.println("Two");
        //         break;
        //     case 3:
        //         System.out.println("Three");
        //         break;
        //     case 4:
        //         System.out.println("Four");
        //         break;
        //     case 5:
        //         System.out.println("Five");
        //         break;
        //     default:
        //         System.out.println("No Match");

        // }

        // switch(n){     // newer version without break statements


        //     case 1, 2 -> System.out.println("Either one or two"); // we can merge
        //     // case 2 -> System.out.println("Two");
        //     case 3 -> System.out.println("Three");
        //     case 4 -> System.out.println("Four");
        //     case 5 -> System.out.println("Five");
        //     default -> System.out.println("No match");

        // }

        String result = "";
        result = switch(n){     // newer version without break statements


            case 1, 2 -> "Either one or two";    // we can merge
            // case 2 -> System.out.println("Two");
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            default -> "No match";

        };     // additional semicolon

        System.out.println(result);
    }

}
