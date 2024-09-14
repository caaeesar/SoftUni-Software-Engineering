function lockedProfile() {
  let buttonElements = document.querySelectorAll("div.profile button");

  function showMoreClickHadler(event) {
    let button = event.target;
    let profile = button.parentNode;
    let hiddenInfo = button.parentElement.querySelector("div");
    let lockStatus = profile.querySelector('input[type="radio"]:checked').value;

    if (lockStatus === "unlock") {
      if (button.textContent === "Show more") {
        hiddenInfo.style.display = "inline-block";
        button.textContent = "Hide it";
      } else if (button.textContent === "Hide it") {
        hiddenInfo.style.display = "none";
        button.textContent = "Show more";
      }
    }
  }

  buttonElements.forEach((button) => {
    button.addEventListener("click", showMoreClickHadler);
  });
}
