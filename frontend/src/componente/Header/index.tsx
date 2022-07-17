import Logo from '../../assets/img/Logo.svg'
import './style.css'
function Header(){
    return(
        <header>
        <div className="dsmeta-logo-container">
            <img src={Logo} alt="DSMeta" />
            <h1>DSMeta</h1>
            <p>
              Desenvolvido por
              <a>&emsp;Marcos Andrade</a>
            </p>
        </div>
    </header>
    );
}

export default Header;