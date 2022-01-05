pipeline {
   agent any
   stages {
        stage('Git Checkout') {
            steps {
                git branch: 'master', url:'https://github.com/gpd38/desafioBase2AutomacaoSeleniumWebDriverJava.git'            
            }
        }
        stage ('Build') {
            steps{
               bat 'mvn clean package -DskipTests=true'
            }
       }
       stage ('Tests') {
            steps{
               bat 'mvn test'
            }
       }
   }
}
