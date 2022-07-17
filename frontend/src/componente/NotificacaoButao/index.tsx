import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/Vector.svg'
import './style.css'

type Props={
  saleId:number;
}
function handleClick(id : number){
  axios.get(`http://localhost:8080/sale/sms/${id}`)
  .then(response=>{
    toast.info("sms enviado com sucesso !");
    console.log("ola mundo")
  })
}

function NotificacaoButton({saleId} : Props) {
    return (
        
        <div className="dsmeta-red-btn" onClick={()=> handleClick(saleId)}>
          <img src={icon} alt="Notificar" />
        </div>
     
    );
  }
  
  export default NotificacaoButton;