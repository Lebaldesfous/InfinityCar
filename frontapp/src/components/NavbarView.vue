<template>
    <div>
        <nav class="navbar navbar-expand-lg bg-danger text-white">
            <div class="container-fluid">
                <a class="navbar-brand text-decoration-none text-white" href="#">Infinity Car</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0" id="listnavbar">
                        <li class="nav-item" v-if="checkSessionCookie()">
                            <RouterLink class="nav-link active text-decoration-none text-white" to="/profile">Profile</RouterLink>
                        </li>
                        <li class="nav-item" v-if="checkIsAdmin()">
                            <RouterLink class="nav-link active text-decoration-none text-white" to="/admin">Administration</RouterLink>
                        </li>
                        <li class="nav-item" v-if="checkSessionCookie()" v-on:click="disconnect()">
                            <RouterLink class="nav-link active text-decoration-none text-white" to="/">Disconnect</RouterLink>
                            
                        </li>
                        <li class="nav-item" v-if="!checkSessionCookie()">
                            <RouterLink class="nav-link active text-decoration-none text-white" to="/login">Login</RouterLink>
                        </li>
                        <li class="nav-item" v-if="!checkSessionCookie()">
                            <RouterLink class="nav-link active text-decoration-none text-white" to="/signin">Sign In</RouterLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</template>

<script>
export default {
    methods: {
    checkSessionCookie() {
      const cookies = document.cookie.split(';');
      for (let i = 0; i < cookies.length; i++) {
        const cookie = cookies[i].trim();
        if (cookie.startsWith('session=')) {
          return true;
        }
      }
      return false;
    },
    checkIsAdmin(){
        const cookies = document.cookie.split(';');
        for (let i = 0; i < cookies.length; i++) {
            const cookie = cookies[i].trim();
            if (cookie.startsWith('session=')) {
                let session = cookie.split('=')[1]
                if(session == "admin" || session == "admin@infinity.com"){
                    return true
                }
            }
        }
    },
    disconnect(){
        document.cookie = `session=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/; SameSite=Strict`;
        window.location.reload()
    }
  }
}
</script>