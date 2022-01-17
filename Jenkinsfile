node ("desafioSelenium"){
        stage('Git Checkout') {
                git branch: 'master', url:'https://github.com/pedronvasconcelos/desafioSelenium.git'
        }
        stage ('restore DB'){
           start cmd.exe /c C:\desafioSelenium\restore.bat
           }
        stage('Builds + Tests') {
               bat 'mvn clean test'
            }
}