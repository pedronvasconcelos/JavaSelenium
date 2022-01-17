node ("Built-In Node"){
   stages {
        stage('Git Checkout') {
            steps {
                git branch: 'master', url:'https://github.com/pedronvasconcelos/desafioSelenium.git'
            }
        }
        stage ('restore DB') {
                    steps{
                       start cmd.exe /c C:/desafioSelenium/restore.bat
                    }
               }
        stage ('Builds + Tests') {
            steps{
               bat 'mvn clean test'
            }
       }
   }
}
