

import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.BinaryExpression
import org.codehaus.groovy.ast.expr.ClosureExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.stmt.*
import org.codehaus.groovy.control.CompilePhase

String codeScript = '''
def function1(String arg) {
    println("First " + arg)
}
// This is a comment

def function2(arg, int arg2) {
    println("Second " + arg)
}

public Integer triple( int a ) {
  3 * a
}
'''
String codeClass = '''

import TestClass3

class TestClass2 {


  int x = 2

  def function1(arg1, String arg2) {
    println(arg1)
  }

  Integer triple( int a ) {
    3 * a
  }

  def printTheInt() {
    println(TestClass3.theInt)
  }
}
'''


//def phase = CompilePhase.PARSING
def phase = CompilePhase.CLASS_GENERATION
def ast = new AstBuilder().buildFromString( phase = phase, statementsOnly = false, source = codeClass )
println ast
//println ast.first().metaClass.methods*.name.sort().unique()
println ast[1].class
println ast[1].getMethods().join("\n")
