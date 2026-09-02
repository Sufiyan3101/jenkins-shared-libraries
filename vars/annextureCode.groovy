def call(String url, String branch){
  echo "After this code cloning will start..."
  git url:"${url}", branch:"${branch}"
  echo "Code has been cloned successfully..."
}
