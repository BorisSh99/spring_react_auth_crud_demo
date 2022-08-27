import axios from "axios";

const CARD_API_BASE_URL = "http://localhost:8080/api/cardboard";

class CardService {

    getCards(){
        return axios.get(CARD_API_BASE_URL);
    }

    getLabels(){
        return axios.get(CARD_API_BASE_URL + "/labels");
    }

}

export default new CardService()
