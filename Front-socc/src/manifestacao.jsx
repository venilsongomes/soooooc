import { useState, useEffect } from 'react'

function Manifestacao(){

    const [manifestacaos, setManifestacao] = useState ([])


 useEffect(() => {
  const  fetchData = async () => {
    try {
      const res = await fetch("http://localhost:8080/manifestacao");
      const data = await res.json();
      setManifestacao(data);
    } catch (err) {
      console.error('Erro ao buscar manifestações:', err);
    }
  };
  fetchData();
}, [manifestacaos]);

console.log(manifestacaos)

    return(<>
    
        <table className="min-w-full bg-white shadow rounded">
          <thead className="bg-gray-200 text-left">
            <tr>
              <th className="p-3">Nome</th>
              <th className="p-3">Área</th>
              <th className="p-3">Facilitador</th>
              <th className="p-3">Docentes</th>
              <th className="p-3">Status</th>
              <th className="p-3">Ações</th>
            </tr>
          </thead>
          <tbody>
             { manifestacaos.map((manistar) => 
              <tr key={manistar}>

                <td className="p-3">{manistar.nucleoConhecimento.nome}</td>
                <td className="p-3">{}</td>
                <td className="p-3">{manistar.facilitador.nome}</td>
                <td className="p-3">
                  <div className="flex items-center space-x-2">
                    <span className="bg-blue-600 text-white px-2 py-1 rounded-full">DOCENTES</span>
                  </div>
                </td>
                <td className="p-3">
                  <span className="bg-green-500 text-white px-2 py-1 rounded">{manistar.status.situacao}</span>
                </td>
                <td className="p-3 text-center">
                  <button className="text-gray-400 hover:text-red-500">🗑️</button>
                </td>
              </tr >
            
            )}
              
                
          </tbody>
        </table>
    

    </>)
}

export default Manifestacao;