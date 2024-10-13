import { createApp } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';

createApp({
    data(){
        return{
            eventLocations: [],
            events: "",
            location: "",

        };

    },
    created(){
        this.loadData();
    },

    methods:{

        loadData(){
            axios
              .get('/api/eventLocation/all')
              .then((response) => {
                this.eventLocations = response.data;

                
              })
              .catch((err) => console.log(err));
        },

        signOut(){
            Swal.fire({
                title: "Are you sure to logout?",
                icon: "info",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Yes!",
            })
            .then((result) => {
                if(result.isConfirmed){
                    axios
                      .post("/api/logout")
                      .then((response) => (window.location.href = "index.html"))
                      .catch((error) => {
                        Swal.fire({
                            icon: "error",
                            title: "Oops...",
                            text: error.response.data,
                        })
                      })
                }
            })
            .catch((error) => console.log(error));
        },


        menuResponsive(){
            let menu = document.querySelector('#menu-icon')
            let navbar = document.querySelector('.navbar');
            
            menu.classList.toggle('bx-x');
            navbar.classList.toggle('open');
        }
    }




}).mount('#app')



