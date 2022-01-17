node ("desafioSelenium"){
   stages {
        stage('Git Checkout') {
            steps {
                git branch: 'master', url:'https://github.com/pedronvasconcelos/desafioSelenium.git'
            }
        }
        stage ('Builds + Tests') {
            steps{
               bat 'mvn clean test'
            }
       }
   }
}
