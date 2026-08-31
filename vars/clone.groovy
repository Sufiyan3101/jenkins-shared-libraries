def call(string url, string branch){
  echo "This is cloning the code..."
  git clone url: "${url}", branch: "${branch}"
  echo "Cloning Successfully..."
}
