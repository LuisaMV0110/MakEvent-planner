import { createApp } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';

createApp({
    data(){
        return{
            // Sign In
            emailL: "",
            passwordL: "",
            // Sign Up
            firstName: "",
            lastName: "",
            emailR: "",
            age: "",
            gender: "",
            passwordR: ""
        };
    },

    methods: {
        signIn(){
            axios.post('/api/login', `email=${this.emailL}&password=${this.passwordL}`)
              .then((response) => window.location.href = '/events.html')
              .catch((error) => Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Wrong email or password",
              }));
        },

        signUp(){
            axios.post('/api/register', {name:this.firstName,lastName:this.lastName,email:this.emailR,age:this.age,gender:this.gender,password:this.passwordR})
            .then((response) => 
                axios
                 .post('/api/login', `email=${this.emailR}&password=${this.passwordR}`))
                 .then((response) => (window.location.href = "/events.html"))
            .catch((error) => Swal.fire({
                icon: "error",
                title:"Oops...",
                text: error.response.data,
            }))
        }

    }



}).mount('#app')





// LOGIN REGISTER
const container = document.querySelector('.container')
const LoginLink = document.querySelector('.SignInLink')
const RegisterLink = document.querySelector('.SignUpLink');
RegisterLink.addEventListener('click', () => {
    container.classList.add('active')
})

LoginLink.addEventListener('click', () => {
    container.classList.remove('active')
})