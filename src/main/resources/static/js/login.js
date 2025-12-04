function doLogin() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch("/api/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `username=${username}&password=${password}`
    })
    .then(r => r.json())
    .then(res => {
        if (res.success) {
            localStorage.setItem("user", JSON.stringify(res.user));
            window.location.href = "/index.html"; // 登录成功后的页面
        } else {
            document.getElementById("errorMsg").innerText = res.msg;
        }
    });
}
