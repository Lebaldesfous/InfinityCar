import axios from "axios"

let api = axios.create({
    baseURL: "http://localhost:8081/",
    headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Credentials': 'true'
    }
})

export default api