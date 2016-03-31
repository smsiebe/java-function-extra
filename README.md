java-function-extra
===================

This project centralizes some additional 'common' functional
interfaces and utilities geoint.org uses within its code.

How to use this library
-----------------------

You may use this project just as you would any other java library.  However, 
the project versioning policy (described below) makes this project a little 
special in that we designed this project in a way that we expect (we won't 
go as far as saying 'recommend') developers will either directly copy these 
classes into their project or use build-time tooling like maven-shade-plugin to 
copy the classes into your code. This project won't cause classpath hell, 
so go nuts.

Project Versioning Policy
-------------------------

To keep with a core tenant of geoint.org code (reducing complex 
runtime dependency chains which may lead to classpath hell), 
all non-snapshot releases of this project will NEVER change any 
contractual interfaces...ever...in fact, this project will NEVER need 
to have a 2.x version because it will never be backwards incompatible.
In other words, if there are two identically named *.class files 
from this project on a classpath, there will NEVER be a concern that 
the CL chose the wrong one (ie no MethodNotFoundException).  

Later versions of this project MAY deprecate an interface by annotating 
it with @DeprecatedFunctionalInterface, but will never be removed.  The 
@DeprecatedFunctionalInterface will refer to a suggested alternative 
functional interface (ie if the JRE adds a new interface) and is useful for 
tooling, such as code quality checkers.

This versioning policy is made possible because this project is really very 
little more than a bunch of (functional) interfaces and contain little 
actual logic.