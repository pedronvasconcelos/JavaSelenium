node ("desafioSelenium"){
        stage('Git Checkout') {
                git branch: 'master', url:'https://github.com/pedronvasconcelos/desafioSelenium.git'
        }
        stage ('restore DB'){
            bat '''
               cd c:/DesafioSelenium
               mysql -u mantisbt -pmantisbt  -e "source bugtracker_backup.sql;"
             '''
           }
        stage('Builds + Tests') {
               bat 'mvn clean test'
            }
}