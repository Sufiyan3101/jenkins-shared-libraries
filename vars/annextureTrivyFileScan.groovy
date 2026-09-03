def call(){
  sh '''
    trivy fs --scanners vuln,secret --severity HIGH,CRITICAL --exit-code 1 .
  '''
}
