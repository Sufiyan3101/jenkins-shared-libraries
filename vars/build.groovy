def call(){
  echo "Building Started..."
  sh "docker compose build"
  echo "Building has been done..."
}
