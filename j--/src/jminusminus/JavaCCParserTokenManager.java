/* JavaCCParserTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. JavaCCParserTokenManager.java */
package jminusminus;
import java.util.ArrayList;

/** Token Manager. */
@SuppressWarnings ("unused")
public class JavaCCParserTokenManager implements JavaCCParserConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x400000000000L) != 0L)
            return 13;
         if ((active0 & 0x1ffffffff000L) != 0L)
         {
            jjmatchedKind = 78;
            return 1;
         }
         return -1;
      case 1:
         if ((active0 & 0x1cfffff7f000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 78;
               jjmatchedPos = 1;
            }
            return 1;
         }
         if ((active0 & 0x30000080000L) != 0L)
            return 1;
         return -1;
      case 2:
         if ((active0 & 0x40000c00000L) != 0L)
            return 1;
         if ((active0 & 0x1affff37f000L) != 0L)
         {
            jjmatchedKind = 78;
            jjmatchedPos = 2;
            return 1;
         }
         return -1;
      case 3:
         if ((active0 & 0x12d8fe36b000L) != 0L)
         {
            jjmatchedKind = 78;
            jjmatchedPos = 3;
            return 1;
         }
         if ((active0 & 0x82701014000L) != 0L)
            return 1;
         return -1;
      case 4:
         if ((active0 & 0x12c07e323000L) != 0L)
         {
            jjmatchedKind = 78;
            jjmatchedPos = 4;
            return 1;
         }
         if ((active0 & 0x1880048000L) != 0L)
            return 1;
         return -1;
      case 5:
         if ((active0 & 0xc00e223000L) != 0L)
         {
            jjmatchedKind = 78;
            jjmatchedPos = 5;
            return 1;
         }
         if ((active0 & 0x120070100000L) != 0L)
            return 1;
         return -1;
      case 6:
         if ((active0 & 0x4008201000L) != 0L)
         {
            jjmatchedKind = 78;
            jjmatchedPos = 6;
            return 1;
         }
         if ((active0 & 0x8006022000L) != 0L)
            return 1;
         return -1;
      case 7:
         if ((active0 & 0x8200000L) != 0L)
         {
            jjmatchedKind = 78;
            jjmatchedPos = 7;
            return 1;
         }
         if ((active0 & 0x4000001000L) != 0L)
            return 1;
         return -1;
      case 8:
         if ((active0 & 0x200000L) != 0L)
         {
            jjmatchedKind = 78;
            jjmatchedPos = 8;
            return 1;
         }
         if ((active0 & 0x8000000L) != 0L)
            return 1;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 61;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x2000L);
      case 37:
         jjmatchedKind = 67;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1000L);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x800000000000000L, 0x0L);
      case 40:
         return jjStopAtPos(0, 49);
      case 41:
         return jjStopAtPos(0, 50);
      case 42:
         jjmatchedKind = 65;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x100L);
      case 43:
         jjmatchedKind = 63;
         return jjMoveStringLiteralDfa1_0(0x400000000000000L, 0x1L);
      case 44:
         return jjStopAtPos(0, 45);
      case 45:
         jjmatchedKind = 62;
         return jjMoveStringLiteralDfa1_0(0x80000000000000L, 0x80L);
      case 46:
         return jjStartNfaWithStates_0(0, 46, 13);
      case 47:
         jjmatchedKind = 66;
         return jjMoveStringLiteralDfa1_0(0x240L, 0x200L);
      case 58:
         return jjStopAtPos(0, 74);
      case 59:
         return jjStopAtPos(0, 53);
      case 60:
         jjmatchedKind = 69;
         return jjMoveStringLiteralDfa1_0(0x1000000000000000L, 0x0L);
      case 61:
         jjmatchedKind = 54;
         return jjMoveStringLiteralDfa1_0(0x100000000000000L, 0x0L);
      case 62:
         jjmatchedKind = 57;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x800L);
      case 63:
         return jjStopAtPos(0, 68);
      case 91:
         return jjStopAtPos(0, 47);
      case 93:
         return jjStopAtPos(0, 51);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x1000L, 0x0L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x1000002000L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x600000c000L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x38000000000L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x30000L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x40000040000L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x780000L, 0x0L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x80000000000L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x1800000L, 0x0L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x1e000000L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x20000000L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x1000c0000000L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x300000000L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x400000000L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x800000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 48);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x40L);
      case 125:
         return jjStopAtPos(0, 52);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0, long active1){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x800000000000000L) != 0L)
            return jjStopAtPos(1, 59);
         break;
      case 42:
         if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(1, 9);
         break;
      case 43:
         if ((active0 & 0x400000000000000L) != 0L)
            return jjStopAtPos(1, 58);
         break;
      case 45:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStopAtPos(1, 55);
         break;
      case 47:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 61:
         if ((active0 & 0x100000000000000L) != 0L)
            return jjStopAtPos(1, 56);
         else if ((active0 & 0x1000000000000000L) != 0L)
            return jjStopAtPos(1, 60);
         else if ((active1 & 0x1L) != 0L)
            return jjStopAtPos(1, 64);
         else if ((active1 & 0x80L) != 0L)
            return jjStopAtPos(1, 71);
         else if ((active1 & 0x100L) != 0L)
            return jjStopAtPos(1, 72);
         else if ((active1 & 0x200L) != 0L)
            return jjStopAtPos(1, 73);
         else if ((active1 & 0x800L) != 0L)
            return jjStopAtPos(1, 75);
         else if ((active1 & 0x1000L) != 0L)
            return jjStopAtPos(1, 76);
         else if ((active1 & 0x2000L) != 0L)
            return jjStopAtPos(1, 77);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x2002040000L, active1, 0L);
      case 98:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x8020800000L, active1, 0L);
      case 102:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(1, 19, 1);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x900004000L, active1, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x18000L, active1, 0L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L, active1, 0L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x600000L, active1, 0L);
      case 111:
         if ((active0 & 0x10000000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0xe4400002000L, active1, 0L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x120c000000L, active1, 0L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x91000000L, active1, 0L);
      case 119:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000000L, active1, 0L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000L, active1, 0L);
      case 124:
         if ((active1 & 0x40L) != 0L)
            return jjStopAtPos(1, 70);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1){
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000c000L);
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000000L);
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x100d04000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x1040000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x84000000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x8002000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x80100000L);
      case 114:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 42, 1);
         break;
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000211000L);
      case 116:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(2, 22, 1);
         return jjMoveStringLiteralDfa3_0(active0, 0x20020000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x20200000000L);
      case 119:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(2, 23, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x9000000000L);
      case 98:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000000L);
      case 100:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(3, 34, 1);
         break;
      case 101:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(3, 16, 1);
         else if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(3, 33, 1);
         else if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 37, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x80020000L);
      case 103:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 43, 1);
         break;
      case 107:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000L);
      case 108:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(3, 24, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x810002000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000L);
      case 114:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(3, 14, 1);
         break;
      case 115:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(3, 32, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x48000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x104048201000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000L);
      case 118:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x6200000L);
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000000000L);
      case 101:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(4, 18, 1);
         else if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(4, 35, 1);
         return jjMoveStringLiteralDfa5_0(active0, 0x8002000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x4050000000L);
      case 107:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 36, 1);
         break;
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
      case 114:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(4, 31, 1);
         return jjMoveStringLiteralDfa5_0(active0, 0x20101000L);
      case 115:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(4, 15, 1);
         break;
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x3000L);
      case 99:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(5, 28, 1);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(5, 30, 1);
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000L);
      case 101:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 41, 1);
         break;
      case 103:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000L);
      case 104:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 44, 1);
         break;
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000000L);
      case 110:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(5, 29, 1);
         return jjMoveStringLiteralDfa6_0(active0, 0x4000200000L);
      case 116:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(5, 20, 1);
         return jjMoveStringLiteralDfa6_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa7_0(active0, 0x201000L);
      case 101:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(6, 25, 1);
         else if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(6, 26, 1);
         break;
      case 110:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(6, 13, 1);
         break;
      case 115:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(6, 17, 1);
         break;
      case 116:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 39, 1);
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000L);
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x4000000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 38, 1);
         return jjMoveStringLiteralDfa8_0(active0, 0x8200000L);
      case 116:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(7, 12, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(8, 27, 1);
         break;
      case 111:
         return jjMoveStringLiteralDfa9_0(active0, 0x200000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0, 0L);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 102:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(9, 21, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0, 0L);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 33;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 81)
                        kind = 81;
                     { jjCheckNAddStates(0, 8); }
                  }
                  else if (curChar == 46)
                     { jjCheckNAdd(13); }
                  else if (curChar == 34)
                     { jjCheckNAddStates(9, 11); }
                  else if (curChar == 39)
                     { jjAddStates(12, 13); }
                  else if (curChar == 36)
                  {
                     if (kind > 78)
                        kind = 78;
                     { jjCheckNAdd(1); }
                  }
                  break;
               case 1:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 78)
                     kind = 78;
                  { jjCheckNAdd(1); }
                  break;
               case 2:
                  if (curChar == 39)
                     { jjAddStates(12, 13); }
                  break;
               case 4:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAdd(5); }
                  break;
               case 5:
                  if (curChar == 39 && kind > 83)
                     kind = 83;
                  break;
               case 6:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     { jjCheckNAdd(5); }
                  break;
               case 7:
                  if (curChar == 34)
                     { jjCheckNAddStates(9, 11); }
                  break;
               case 9:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAddStates(9, 11); }
                  break;
               case 10:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddStates(9, 11); }
                  break;
               case 11:
                  if (curChar == 34 && kind > 84)
                     kind = 84;
                  break;
               case 12:
                  if (curChar == 46)
                     { jjCheckNAdd(13); }
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 87)
                     kind = 87;
                  { jjCheckNAddStates(14, 16); }
                  break;
               case 15:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(16); }
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 87)
                     kind = 87;
                  { jjCheckNAddTwoStates(16, 17); }
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 81)
                     kind = 81;
                  { jjCheckNAddStates(0, 8); }
                  break;
               case 19:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 81)
                     kind = 81;
                  { jjCheckNAdd(19); }
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(20, 21); }
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(22, 23); }
                  break;
               case 23:
                  if (curChar != 46)
                     break;
                  if (kind > 87)
                     kind = 87;
                  { jjCheckNAddStates(17, 19); }
                  break;
               case 24:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 87)
                     kind = 87;
                  { jjCheckNAddStates(20, 22); }
                  break;
               case 26:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(27); }
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 87)
                     kind = 87;
                  { jjCheckNAddTwoStates(27, 17); }
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(28, 29); }
                  break;
               case 30:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAdd(31); }
                  break;
               case 31:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 87)
                     kind = 87;
                  { jjCheckNAddTwoStates(31, 17); }
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(32, 17); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 1:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 78)
                     kind = 78;
                  { jjCheckNAdd(1); }
                  break;
               case 3:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 4:
                  if ((0x14404410000000L & l) != 0L)
                     { jjCheckNAdd(5); }
                  break;
               case 6:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAdd(5); }
                  break;
               case 8:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 9:
                  if ((0x14404410000000L & l) != 0L)
                     { jjCheckNAddStates(9, 11); }
                  break;
               case 10:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAddStates(9, 11); }
                  break;
               case 14:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(23, 24); }
                  break;
               case 17:
                  if ((0x1000000010L & l) != 0L && kind > 87)
                     kind = 87;
                  break;
               case 21:
                  if ((0x100000001000L & l) != 0L && kind > 82)
                     kind = 82;
                  break;
               case 25:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(25, 26); }
                  break;
               case 29:
                  if ((0x2000000020L & l) != 0L)
                     { jjAddStates(27, 28); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 6:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 10:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(9, 11); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 33 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_2(){
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_2(0x400L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_2(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(1, 10);
         break;
      default :
         return 2;
   }
   return 2;
}
private int jjMoveStringLiteralDfa0_1()
{
   return jjMoveNfa_1(0, 0);
}
private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 7)
                        kind = 7;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if (curChar == 10 && kind > 7)
                     kind = 7;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, 
"\141\142\163\164\162\141\143\164", "\142\157\157\154\145\141\156", "\143\150\141\162", "\143\154\141\163\163", 
"\145\154\163\145", "\145\170\164\145\156\144\163", "\146\141\154\163\145", "\151\146", 
"\151\155\160\157\162\164", "\151\156\163\164\141\156\143\145\157\146", "\151\156\164", "\156\145\167", 
"\156\165\154\154", "\160\141\143\153\141\147\145", "\160\162\151\166\141\164\145", 
"\160\162\157\164\145\143\164\145\144", "\160\165\142\154\151\143", "\162\145\164\165\162\156", 
"\163\164\141\164\151\143", "\163\165\160\145\162", "\164\150\151\163", "\164\162\165\145", 
"\166\157\151\144", "\167\150\151\154\145", "\142\162\145\141\153", "\143\141\163\145", 
"\143\157\156\164\151\156\165\145", "\144\145\146\141\165\154\164", "\144\157", "\144\157\165\142\154\145", 
"\146\157\162", "\154\157\156\147", "\163\167\151\164\143\150", "\54", "\56", "\133", "\173", 
"\50", "\51", "\135", "\175", "\73", "\75", "\55\55", "\75\75", "\76", "\53\53", 
"\46\46", "\74\75", "\41", "\55", "\53", "\53\75", "\52", "\57", "\45", "\77", "\74", 
"\174\174", "\55\75", "\52\75", "\57\75", "\72", "\76\75", "\45\75", "\41\75", null, null, 
null, null, null, null, null, null, null, null, null, null, null, };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}
static final int[] jjnextStates = {
   19, 20, 21, 22, 23, 28, 29, 32, 17, 8, 10, 11, 3, 6, 13, 14, 
   17, 24, 25, 17, 25, 17, 24, 15, 16, 26, 27, 30, 31, 
};

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   switch(curLexState)
   {
     case 0:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       if (jjmatchedPos == 0 && jjmatchedKind > 90)
       {
          jjmatchedKind = 90;
       }
       break;
     case 1:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos == 0 && jjmatchedKind > 8)
       {
          jjmatchedKind = 8;
       }
       break;
     case 2:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_2();
       if (jjmatchedPos == 0 && jjmatchedKind > 11)
       {
          jjmatchedKind = 11;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public JavaCCParserTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public JavaCCParserTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 33; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "IN_SINGLE_LINE_COMMENT",
   "IN_MULTI_LINE_COMMENT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, 1, 0, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xfffffffffffff001L, 0x49e7fffL, 
};
static final long[] jjtoSkip = {
   0xffeL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x0L, 0x0L, 
};
static final long[] jjtoMore = {
   0x0L, 0x0L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[33];
    private final int[] jjstateSet = new int[2 * 33];
    private final StringBuilder jjimage = new StringBuilder();
    private StringBuilder image = jjimage;
    private int jjimageLen;
    private int lengthOfMatch;
    protected int curChar;
}
