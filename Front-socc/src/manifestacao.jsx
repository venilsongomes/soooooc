import { useState, useEffect } from 'react'

function Manifestacao(){

    const [manifestacaos, setManifestacao] = useState ([])
    const [reload, setReload] = useState(false)

 async function deleteManifestacao(id) {
    try {
      await fetch(`http://localhost:8080/manifestacao/${id}`, {
        method: 'DELETE'
      });
      setReload(r => !r); // Atualiza a lista após deletar
    } catch (err) {
      console.error('Erro ao deletar manifestação:', err);
    }
  }

    
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
}, [reload]);
// Nenhum código adicional necessário aqui para indentação.


console.log(manifestacaos)

    return (
      <>
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
            {manifestacaos.map((manistar) => (
              <tr key={manistar.id}>
                <td className="p-3">{}</td>
                <td className="p-3">{}</td>
                <td className="p-3">{}</td>
                <td className="p-3">
                  <div className="flex items-center space-x-2">
                    <span className="bg-blue-600 text-white px-2 py-1 rounded-full">
                      {}
                    </span>
                  </div>
                </td>
                <td className="p-3">
                  <span className={`bg-green-500 text-white px-2 py-1 rounded 
                     ${manistar.status.situacao === 'fechado'
                      ? 'bg-red-500'
                      : manistar.status.situacao === 'aceito'
                      ? 'bg-sky-500'
                      : manistar.status.situacao === 'aberto'
                      ? 'bg-green-500'
                      : 'bg-red-500' } `}>
                    {manistar.status.situacao}
                  </span>
                </td>
                <td className="p-3 text-center">
                  <button
                    onClick={() => deleteManifestacao(manistar.id)}
                                  className={`px-2 py-1 rounded text-white
                    ${
                      manistar.status.situacao === 'aberto'
                        ? 'bg-green-500 hover:bg-green-600'
                        : 'bg-gray-400 cursor-not-allowed'
                    }`}
                  disabled={manistar.status.situacao !== 'aberto'}
                  title={
                    manistar.status.situacao !== 'aberto'
                      ? 'Só é possível excluir manifestações com status ABERTO'
                      : 'Deletar'
                  }
                                >
                    🗑️
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </>
    )
}

export default Manifestacao;