/* Generated By:JavaCC: Do not edit this line. DemoParser.java */
package demo;

import java.util.List;
import java.util.ArrayList;
import java.lang.*;
import java.util.LinkedList;

public class DemoParser implements DemoParserConstants {

public static LinkedList<String> variables=new LinkedList<String>();
public static LinkedList<Double> values=new LinkedList<Double>();


//values for one-dimensional tab
public static LinkedList<String> variables_1dim_array = new LinkedList<String>();
public static LinkedList<Double> values_1dim_array = new LinkedList<Double>();


//variables & values for two-dimensional tab rozkminic to
public static LinkedList<LinkedList<Integer>> indexes_2dim_array = new LinkedList<LinkedList<Integer>>();
public static LinkedList<Double> values_2dim_array = new LinkedList<Double>();

  final public void Start() throws ParseException, NumberFormatException {
        double d=0.0;
        double x=0.0;
    label_1:
    while (true) {
      if (jj_2_1(5)) {
        ;
      } else {
        break label_1;
      }
      statement();
    }
    jj_consume_token(0);
  }

  final public void statement() throws ParseException, NumberFormatException {
     Token t;
     double w;
    if (jj_2_2(5)) {
      assign_value();
    } else if (jj_2_3(5)) {
      assign_with_no_value();
    } else if (jj_2_4(5)) {
      Expression();
    } else if (jj_2_5(5)) {
      setValue();
    } else if (jj_2_6(5)) {
      ifElse();
    } else if (jj_2_7(5)) {
      assign_1dim_table();
    } else if (jj_2_8(5)) {
      assign_2dim_table();
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ifElse() throws ParseException, NumberFormatException {
        boolean cond = false;
        Token token;
        double d = 0.0;
        double x = 0.0;
    jj_consume_token(IF);
    jj_consume_token(OPEN_PAR);
    cond = condition();
    token = jj_consume_token(CLOSE_PAR);
        if(cond == false)
        {
                while(token.kind != ELSE)
                 {
                token = getNextToken();
         }
        }
    label_2:
    while (true) {
      if (jj_2_9(5)) {
        ;
      } else {
        break label_2;
      }
      statement();
    }
        if(cond == true)
        {
                while(token.kind != CLOSE_BRACE)
                {
                        token = getNextToken();
                }
        }
    label_3:
    while (true) {
      if (jj_2_10(5)) {
        ;
      } else {
        break label_3;
      }
      jj_consume_token(ELSE);
      label_4:
      while (true) {
        if (jj_2_11(5)) {
          ;
        } else {
          break label_4;
        }
        statement();
      }
    }
    jj_consume_token(END);
  }

  final public boolean condition() throws ParseException, NumberFormatException {
Token n,m;
boolean result = false;
    n = jj_consume_token(NUMBER);
    if (jj_2_12(5)) {
      jj_consume_token(LESS_THAN);
      m = jj_consume_token(NUMBER);
        if(Double.parseDouble(n.image) < Double.parseDouble(m.image))
        {
                result = true;
        }
        {if (true) return result;}
    } else if (jj_2_13(5)) {
      jj_consume_token(GREATER_THAN);
      m = jj_consume_token(NUMBER);
        if(Double.parseDouble(n.image) > Double.parseDouble(m.image))
        {
                result = true;
        }
        {if (true) return result;}
    } else if (jj_2_14(5)) {
      jj_consume_token(LOGIC_EQUALITY);
      m = jj_consume_token(NUMBER);
        if(Double.parseDouble(n.image) == Double.parseDouble(m.image))
        {
                result = true;
        }
        {if (true) return result;}
    } else if (jj_2_15(5)) {
      jj_consume_token(LOGIC_INEQUALITY);
      m = jj_consume_token(NUMBER);
        if(Double.parseDouble(n.image) != Double.parseDouble(m.image))
        {
                result = true;
        }
        {if (true) return result;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public double assign() throws ParseException, NumberFormatException {
     Token t;
     Double d;
    jj_consume_token(DOUBLE);
    t = jj_consume_token(VARIABLE);
    jj_consume_token(ASSIGNMENT);
    d = Expression();
    {if (true) return d;}
    throw new Error("Missing return statement in function");
  }

  final public void assign_value() throws ParseException, NumberFormatException {
     Token t;
     double d;
    jj_consume_token(DOUBLE);
    t = jj_consume_token(VARIABLE);
    jj_consume_token(ASSIGNMENT);
    d = Expression();
        variables.add(t.image);
        values.add(d);
  }

  final public void assign_with_no_value() throws ParseException, NumberFormatException {
 Token t;
 double d;
    jj_consume_token(DOUBLE);
    t = jj_consume_token(VARIABLE);
        variables.add(t.image);
        values.add(0.0);
  }

  final public void assign_1dim_table() throws ParseException, NumberFormatException {
Token t, size1;
    jj_consume_token(INT);
    jj_consume_token(OPEN_SQUARE);
    jj_consume_token(CLOSE_SQUARE);
    t = jj_consume_token(VARIABLE);
    jj_consume_token(ASSIGNMENT);
    jj_consume_token(OPEN_SQUARE);
    size1 = jj_consume_token(NUMBER);
    jj_consume_token(CLOSE_SQUARE);
                int x = Integer.parseInt(size1.image);
                int [] tab = new int [x];
                for(int i=0;i<x;i++)
                {
                        tab[i] = 0;
                }

                for(int i=0;i<x;i++)
                {
                        System.out.println(tab[i]);
                }
  }

  final public void assign_2dim_table() throws ParseException, NumberFormatException {
Token t, size1, size2;
    jj_consume_token(INT);
    jj_consume_token(OPEN_SQUARE);
    jj_consume_token(CLOSE_SQUARE);
    jj_consume_token(OPEN_SQUARE);
    jj_consume_token(CLOSE_SQUARE);
    t = jj_consume_token(VARIABLE);
    jj_consume_token(ASSIGNMENT);
    jj_consume_token(OPEN_SQUARE);
    size1 = jj_consume_token(NUMBER);
    jj_consume_token(COMA);
    size2 = jj_consume_token(NUMBER);
    jj_consume_token(CLOSE_SQUARE);
                int s1 = Integer.parseInt(size1.image);
                int s2 = Integer.parseInt(size2.image);
                int [][] tab = new int[s1][s2];
                for(int i=0;i<s1;i++){
                        for(int j=0;j<s2;j++){
                                tab[i][j] = 0;
                        }
                }
                for(int i=0;i<s1;i++){
                        for(int j=0;j<s2;j++){
                                System.out.println(tab[i][j]);
                        }
                }
  }

  final public void setValue() throws ParseException, NumberFormatException {
     Token t;
     double d;
     int i;
    jj_consume_token(AS);
    t = jj_consume_token(VARIABLE);
    jj_consume_token(ASSIGNMENT);
    d = Expression();
        i=variables.indexOf(t.image);
        values.set(i,d);
  }

  final public double Primary() throws ParseException, NumberFormatException {
        Token token;
        double d;
        int i;
    if (jj_2_16(5)) {
      token = jj_consume_token(NUMBER);
         {if (true) return Double.parseDouble(token.image);}
    } else if (jj_2_17(5)) {
      jj_consume_token(OPEN_PAR);
      d = Expression();
      jj_consume_token(CLOSE_PAR);
         {if (true) return d;}
    } else if (jj_2_18(5)) {
      token = jj_consume_token(VARIABLE);
         i=variables.indexOf(token.image);
        {if (true) return values.get(i);}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public double Expression() throws ParseException, NumberFormatException {
        double i;
        double value;
    value = Term();
    label_5:
    while (true) {
      if (jj_2_19(5)) {
        ;
      } else {
        break label_5;
      }
      if (jj_2_20(5)) {
        jj_consume_token(PLUS);
        i = Term();
         value += i;
      } else if (jj_2_21(5)) {
        jj_consume_token(MINUS);
        i = Term();
         value -= i;
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
         System.out.println(value);
        {if (true) return value;}
    throw new Error("Missing return statement in function");
  }

  final public double Term() throws ParseException, NumberFormatException {
        double i;
        double value;
    value = Primary();
    label_6:
    while (true) {
      if (jj_2_22(5)) {
        ;
      } else {
        break label_6;
      }
      if (jj_2_23(5)) {
        jj_consume_token(TIMES);
        i = Primary();
         value *= i;
      } else if (jj_2_24(5)) {
        jj_consume_token(DIVIDE);
        i = Primary();
         value /= i;
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
         {if (true) return value;}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  private boolean jj_2_11(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  private boolean jj_2_12(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_12(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(11, xla); }
  }

  private boolean jj_2_13(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_13(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(12, xla); }
  }

  private boolean jj_2_14(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_14(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(13, xla); }
  }

  private boolean jj_2_15(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_15(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(14, xla); }
  }

  private boolean jj_2_16(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_16(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(15, xla); }
  }

  private boolean jj_2_17(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_17(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(16, xla); }
  }

  private boolean jj_2_18(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_18(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(17, xla); }
  }

  private boolean jj_2_19(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_19(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(18, xla); }
  }

  private boolean jj_2_20(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_20(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(19, xla); }
  }

  private boolean jj_2_21(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_21(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(20, xla); }
  }

  private boolean jj_2_22(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_22(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(21, xla); }
  }

  private boolean jj_2_23(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_23(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(22, xla); }
  }

  private boolean jj_2_24(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_24(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(23, xla); }
  }

  private boolean jj_3_24() {
    if (jj_scan_token(DIVIDE)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3_13() {
    if (jj_scan_token(GREATER_THAN)) return true;
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  private boolean jj_3_23() {
    if (jj_scan_token(TIMES)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3_22() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_23()) {
    jj_scanpos = xsp;
    if (jj_3_24()) return true;
    }
    return false;
  }

  private boolean jj_3_18() {
    if (jj_scan_token(VARIABLE)) return true;
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_3R_16()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_22()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_12() {
    if (jj_scan_token(LESS_THAN)) return true;
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  private boolean jj_3_17() {
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_10()) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_scan_token(IF)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3_11() {
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_scan_token(NUMBER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_12()) {
    jj_scanpos = xsp;
    if (jj_3_13()) {
    jj_scanpos = xsp;
    if (jj_3_14()) {
    jj_scanpos = xsp;
    if (jj_3_15()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_16()) {
    jj_scanpos = xsp;
    if (jj_3_17()) {
    jj_scanpos = xsp;
    if (jj_3_18()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_16() {
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_scan_token(INT)) return true;
    if (jj_scan_token(OPEN_SQUARE)) return true;
    if (jj_scan_token(CLOSE_SQUARE)) return true;
    if (jj_scan_token(OPEN_SQUARE)) return true;
    if (jj_scan_token(CLOSE_SQUARE)) return true;
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_scan_token(DOUBLE)) return true;
    if (jj_scan_token(VARIABLE)) return true;
    return false;
  }

  private boolean jj_3_10() {
    if (jj_scan_token(ELSE)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_11()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_8() {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3_7() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3_21() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3_6() {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3_15() {
    if (jj_scan_token(LOGIC_INEQUALITY)) return true;
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3_20() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3_19() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_20()) {
    jj_scanpos = xsp;
    if (jj_3_21()) return true;
    }
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_9()) return true;
    return false;
  }

  private boolean jj_3_9() {
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3R_10() {
    if (jj_3R_15()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_19()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_7() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3_4()) {
    jj_scanpos = xsp;
    if (jj_3_5()) {
    jj_scanpos = xsp;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_3_7()) {
    jj_scanpos = xsp;
    if (jj_3_8()) return true;
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3R_11() {
    if (jj_scan_token(AS)) return true;
    if (jj_scan_token(VARIABLE)) return true;
    if (jj_scan_token(ASSIGNMENT)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3R_8() {
    if (jj_scan_token(DOUBLE)) return true;
    if (jj_scan_token(VARIABLE)) return true;
    if (jj_scan_token(ASSIGNMENT)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3_14() {
    if (jj_scan_token(LOGIC_EQUALITY)) return true;
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_scan_token(INT)) return true;
    if (jj_scan_token(OPEN_SQUARE)) return true;
    if (jj_scan_token(CLOSE_SQUARE)) return true;
    if (jj_scan_token(VARIABLE)) return true;
    if (jj_scan_token(ASSIGNMENT)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public DemoParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[24];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public DemoParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public DemoParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new DemoParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public DemoParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new DemoParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public DemoParser(DemoParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(DemoParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[35];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 0; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 35; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 24; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
            case 11: jj_3_12(); break;
            case 12: jj_3_13(); break;
            case 13: jj_3_14(); break;
            case 14: jj_3_15(); break;
            case 15: jj_3_16(); break;
            case 16: jj_3_17(); break;
            case 17: jj_3_18(); break;
            case 18: jj_3_19(); break;
            case 19: jj_3_20(); break;
            case 20: jj_3_21(); break;
            case 21: jj_3_22(); break;
            case 22: jj_3_23(); break;
            case 23: jj_3_24(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
