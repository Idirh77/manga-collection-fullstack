import { useEffect, useState } from 'react'
import axios from 'axios'

function App() {
  const [mangas, setMangas] = useState([])
  const [newManga, setNewManga] = useState({ titre: '', auteur: '', tomeNumero: 1, possede: false })

  // Récupérer les mangas depuis l'API Java
  const fetchMangas = async () => {
    const res = await axios.get('http://localhost:8080/api/mangas')
    setMangas(res.data)
  }

  useEffect(() => { fetchMangas() }, [])

  // Ajouter un manga via l'API Java
  const addManga = async (e) => {
    e.preventDefault()
    await axios.post('http://localhost:8080/api/mangas', newManga)
    setNewManga({ titre: '', auteur: '', tomeNumero: 1, possede: false })
    fetchMangas()
  }

  return (
    <div className="min-h-screen bg-gray-100 p-8">
      <h1 className="text-3xl font-bold text-center mb-8">📚 Ma Collection de Mangas (Java + React)</h1>
      
      <form onSubmit={addManga} className="max-w-md mx-auto bg-white p-6 rounded shadow-md mb-8">
        <input className="w-full border p-2 mb-2" placeholder="Titre" value={newManga.titre} onChange={e => setNewManga({...newManga, titre: e.target.value})} required />
        <input className="w-full border p-2 mb-2" placeholder="Auteur" value={newManga.auteur} onChange={e => setNewManga({...newManga, auteur: e.target.value})} />
        <button className="w-full bg-blue-600 text-white p-2 rounded">Ajouter à la collection</button>
      </form>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {mangas.map(manga => (
          <div key={manga.id} className="bg-white p-4 rounded shadow">
            <h2 className="font-bold text-xl">{manga.titre}</h2>
            <p className="text-gray-600">Auteur: {manga.auteur}</p>
            <p className="text-sm">Tome n°{manga.tomeNumero}</p>
          </div>
        ))}
      </div>
    </div>
  )
}

export default App