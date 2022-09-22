<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style/css.css">

</head>
<body>

<br>
<br>
    <div class="cont">
        <div class="form sign-in">
            <h2>Welcome</h2>
            <form action="login" method="post">
            <div class="alert alert-success" role="alert">
            	<p style="text-align: center;color: red;">${message}</p>
			</div>
            <label>
                <span>Email</span>
                <input type="text" name="username" placeholder="Username" required="" autofocus="" />
            </label>
            <label>
                <span>Password</span>
                <input type="password" name="password" placeholder="Password" required="" />
            </label>
            <p class="forgot-pass">Forgot password?</p>
            <button type="submit" class="submit">Sign In</button>
         	</form>
        </div>
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                 
                    <h3>Don't have an account? Please Sign up!<h3>
                </div>
                <div class="img__text m--in">
                
                    <h3>If you already has an account, just sign in.<h3>
                </div>
                <div class="img__btn">
                    <span class="m--up">Sign Up</span>
                    <span class="m--in">Sign In</span>
                </div>
            </div>
            <div class="form sign-up">
            <form action="signup" method="post">
                <h2>Create your Account</h2>
                <div class="alert alert-success" role="alert">
            		<p style="text-align: center;color: red;">${message}</p>
				</div>
                <label>
                    <span>Username</span>
                    <input type="text" name="username" value="" />
                </label>
                <label>
                    <span>email</span>
                    <input type="text" name="email" value="" />
                </label>
                <label>
                    <span>password</span>
                    <input type="password" name="password" value="" />
                </label>
                <label>
                    <span>Repeatpassword</span>
                    <input type="password" name="Repeatpassword" value="" />
                </label>                
                <button type="submit" class="submit">Sign Up</button>
            </form>
            </div>
        </div>
    </div>

    <script>
        document.querySelector('.img__btn').addEventListener('click', function() {
            document.querySelector('.cont').classList.toggle('s--signup');
        });
    </script>
</body>
</html>