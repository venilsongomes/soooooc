import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import Manifestacao from './manifestacao';


function App() {
  const [nucleo, setNucleo] = useState([])
  const [selectedNucleo, setSelectedNucleo] = useState('');
 const [reloadManifestacoes, setReloadManifestacoes] = useState(false);

 var idUser = 1;


 useEffect(() => {
  const  fetchData = async () => {
    try {
      const res = await fetch("http://localhost:8080/nucleo");
      const data = await res.json();
      setNucleo(data);
    } catch (err) {
      console.error('Erro ao buscar nucleo:', err);
    }
  };
  fetchData();
  

}, []);

const handleManifestarIntencao = async () => {
  if (!selectedNucleo) {
    alert('Selecione um núcleo!');
    return;
  }

  try {
    await fetch('http://localhost:8080/manifestacao', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },


      body: JSON.stringify({
        docente:{ id: idUser},
        nucleoConhecimento: { id: Number(selectedNucleo) },
        status: { id: 1 } 

        
      }),
    });
    alert('Manifestação enviada!');
     setReloadManifestacoes(r => !r);
  } catch (err) {
    alert('Erro ao manifestar intenção');
    console.error(err);
  }
};
<Manifestacao reload={reloadManifestacoes}/>



  return (
    <>
      <div className="flex h-screen">
      {/* Menu lateral */}
      <aside className="w-64 bg-[#083c55] text-white p-4 space-y-4">
        <h1 className="text-2xl font-bold mb-4">SOOC</h1>
        <nav className="space-y-2">
          <a href="#" className="block hover:underline">Página Inicial</a>
          <a href="#" className="block hover:underline">Núcleos de Conhecimento</a>
          <a href="#" className="block bg-[#0a5e7a] p-2 rounded">Manifestar Intenção</a>
          <a href="#" className="block hover:underline">Histórico de Manifestações</a>
        </nav>
      </aside>

      {/* Conteúdo principal */}
      <main className="flex-1 bg-gray-100 p-6">
        <h2 className="text-xl font-semibold mb-4">Manifestar Intenção em Núcleos de Conhecimento</h2>

        {/* Dropdown + botão */}
        <div className="flex items-center gap-4 mb-6">
          <select
          className="p-2 border rounded w-1/2"
          value={selectedNucleo}
          onChange={e => setSelectedNucleo(e.target.value)}
          
        
          >
            <option> Selecione Um núcleo</option>

             {nucleo.map((nucleos) => (
               <option key={nucleos.id} value={nucleos.id}>
                {nucleos.nome}
               </option>
             )) 
          }
            
          </select>
          <button className="bg-[#083c55] text-white px-4 py-2 rounded" onClick={handleManifestarIntencao}>Manifestar Intenção</button>
        </div>

        <Manifestacao></Manifestacao>

        <div className="mt-6">
          <button className="border border-[#083c55] text-[#083c55] px-6 py-2 rounded hover:bg-[#e6f0f3]">Voltar</button>
        </div>
      </main>
    </div>
    </>
  )
}

export default App
