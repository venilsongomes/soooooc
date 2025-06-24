import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'


function App() {
  const [manifestacoes, setManifestacoes] = useState([])

  useEffect(() => {
  const fetchData = async () => {
    try {
      const res = await fetch("http://localhost:8080/status");
      if (!res.ok) throw new Error(`HTTP error! status: ${res.status}`);
      const data = await res.json();
      setManifestacoes(data);
    } catch (err) {
      console.error('Erro ao buscar manifestações:', err);
    }
  };
  fetchData();
}, []);

console.log(manifestacoes)
  return (
    <>
      <div className="flex h-screen">
      {/* Menu lateral */}
      <aside className="w-64 bg-[#083c55] text-white p-4 space-y-4">
        <h1 className="text-2xl font-bold mb-4">SGTC</h1>
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
          >
            <option>Conceitos, Métodos e Técnicas de Computação</option>
            <option>Engenharia de Software</option>
            <option>Redes de Computadores</option>
          </select>
          <button className="bg-[#083c55] text-white px-4 py-2 rounded">Manifestar Intenção</button>
        </div>

        {/* Tabela */}
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
            
              <tr className="border-t">
                <td className="p-3">NOME</td>
                <td className="p-3">AREA</td>
                <td className="p-3">FACILITADOR</td>
                <td className="p-3">
                  <div className="flex items-center space-x-2">
                    <span className="bg-blue-600 text-white px-2 py-1 rounded-full">DOCENTES</span>
                  </div>
                </td>
                <td className="p-3">
                  <span className="bg-green-500 text-white px-2 py-1 rounded">STATUS</span>
                </td>
                <td className="p-3 text-center">
                  <button className="text-gray-400 hover:text-red-500">🗑️</button>
                </td>
              </tr>
          </tbody>
        </table>

        <div className="mt-6">
          <button className="border border-[#083c55] text-[#083c55] px-6 py-2 rounded hover:bg-[#e6f0f3]">Voltar</button>
        </div>
      </main>
    </div>
    </>
  )
}

export default App
