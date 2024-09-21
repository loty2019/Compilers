package simpleops;

import java.util.ArrayList;

import jminusminus.CLEmitter;

import static jminusminus.CLConstants.*;

/**
 * This class programmatically generates the class file for the following Java application:
 *
 * <pre>
 * public class IsPrime {
 *     // Entry point.
 *     public static void main(String[] args) {
 *         int n = Integer.parseInt(args[0]);
 *         boolean result = isPrime(n);
 *         System.out.println(result);
 *     }
 *
 *     // Returns true if n is prime, and false otherwise.
 *     private static boolean isPrime(int n) {
 *         if (n < 2) {
 *             return false;
 *         }
 *         for (int i = 2; i <= n / i; i++) {
 *             if (n % i == 0) {
 *                 return false;
 *             }
 *         }
 *         return true;
 *     }
 * }
 * </pre>
 */
public class GenIsPrime {
    public static void main(String[] args) {
        CLEmitter e = new CLEmitter(true);

        // Create an ArrayList instance to store modifiers
        ArrayList<String> modifiers = new ArrayList<String>();

        // public class IsPrime {
        modifiers.add("public");
        e.addClass(modifiers, "IsPrime", "java/lang/Object", null, true);

        // public static void main(String[] args) {
        modifiers.clear();
        modifiers.add("public");
        modifiers.add("static");
        e.addMethod(modifiers, "main", "([Ljava/lang/String;)V", null, true);

        // int n = Integer.parseInt(args[0])
        e.addNoArgInstruction(ALOAD_0);
        e.addNoArgInstruction(ICONST_0);
        e.addNoArgInstruction(AALOAD);
        e.addMemberAccessInstruction(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I");
        e.addNoArgInstruction(ISTORE_1);

        // boolean result = isPrime(n);
        e.addNoArgInstruction(ILOAD_1);
        e.addMemberAccessInstruction(INVOKESTATIC, "IsPrime", "isPrime", "(I)Z");
        e.addNoArgInstruction(ISTORE_2);

        // System.out.println(result);
        e.addMemberAccessInstruction(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        e.addNoArgInstruction(ILOAD_2);
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Z)V");

        e.addNoArgInstruction(RETURN);

        // private static boolean isPrime(int n) {
        modifiers.clear();
        modifiers.add("private");
        modifiers.add("static");
        e.addMethod(modifiers, "isPrime", "(I)Z", null, true);

        //if  (n < 2)  branch to Recurse
        e.addNoArgInstruction(ILOAD_0);
        e.addNoArgInstruction(ICONST_2);
        e.addBranchInstruction(IF_ICMPGE, "ForLoop");

        // base case retunr false
        e.addNoArgInstruction(ICONST_0);
        e.addNoArgInstruction(IRETURN);

        // Recursive case for (int i = 2; i <= n / i; i ++)
        e.addLabel("ForLoop");
        e.addNoArgInstruction(ICONST_2);
        e.addNoArgInstruction(ISTORE_1);
        e.addLabel("StartLoop");
        e.addNoArgInstruction(ILOAD_1); // i
        e.addNoArgInstruction(ILOAD_0); // n
        e.addNoArgInstruction(ILOAD_1); // i for n/i
        e.addNoArgInstruction(IDIV);
        e.addBranchInstruction(IF_ICMPGT, "EndLoop");

        // body  if ( n % i == 0)
        e.addNoArgInstruction(ILOAD_0); // n
        e.addNoArgInstruction(ILOAD_1); // i
        e.addNoArgInstruction(IREM);
        e.addNoArgInstruction(ICONST_0); // put on the stck the 0 and then fodo % == 0
        e.addBranchInstruction(IF_ICMPNE, "Restart");

        //base case return false
        e.addNoArgInstruction(ICONST_0);
        e.addNoArgInstruction(IRETURN);

        // increment i++ and go back to the start
        e.addLabel("Restart");
        e.addNoArgInstruction(ILOAD_1);
        e.addNoArgInstruction(ICONST_1);
        e.addNoArgInstruction(IADD);
        e.addNoArgInstruction(ISTORE_1);
        e.addBranchInstruction(GOTO, "StartLoop");

        // lable for end
        e.addLabel("EndLoop");

        // return true
        e.addNoArgInstruction(ICONST_1);
        e.addNoArgInstruction(IRETURN);

        e.write();
    }
}
