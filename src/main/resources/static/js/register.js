function doRegister() {
    let name = document.getElementById("name").value.trim();
    let username = document.getElementById("username").value.trim();
    let email = document.getElementById("email").value.trim();
    let password = document.getElementById("password").value.trim();
    let password2 = document.getElementById("password2").value.trim();
    let error = document.getElementById("errorMsg");

    error.innerText = "";

    if (!name || !username || !email || !password || !password2) {
        error.innerText = "请填写完整信息";
        return;
    }

    if (password !== password2) {
        error.innerText = "两次密码不一致";
        return;
    }

    fetch("http://localhost:8080/register", { // 注意：改成后端地址
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            name: name,
            username: username,
            email: email,
            password: password
        })
    })
    .then(async res => {
        let text = await res.text();
        try {
            return JSON.parse(text); // 注册成功返回的 User JSON
        } catch {
            return text; // 错误信息字符串
        }
    })
    .then(data => {
        if (typeof data === "string") {
            error.innerText = data; // 后端返回错误信息
            return;
        }

        alert("注册成功，请登录");
        window.location.href = "/login.html";
    })
    .catch(() => {
        error.innerText = "请求失败，请稍后再试";
    });
}

