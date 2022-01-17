node ("desafioSelenium"){
        stage('Git Checkout') {
                git branch: 'master', url:'https://github.com/pedronvasconcelos/desafioSelenium.git'
        }
        stage('Builds + Tests') {
               bat 'mvn clean test'
            }
}