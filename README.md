_Currency Exchange Service version 0.05_

**INSTALLATION:**

1. git clone repo
2. run mvn -N io.takari:maven:wrapper
3. run ./mvnw spring-boot:run

**ABOUT:**

Application is used to exchange currencies. 
API endpoint is:
GET /exchange?amount={amount}&entryCode={entryCode}&targetCode={targetCode}
