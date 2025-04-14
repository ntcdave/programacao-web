<?php
require_once 'modelos/Contato.php';

class ContatoDAO {
    public function salvar($contato, $conn) {
        try {
            $sql = "INSERT INTO Contatos(nome,telefone) VALUES (?,?)";
            $stmt = $conn->prepare($sql);
            $stmt->bindValue(1, $contato->getNome());
            $stmt->bindValue(2, $contato->getTelefone());
            $stmt->execute();
            $id = $conn->lastInsertId();
            $contato->setId($id);
            return $contato;
        } catch(Exception $erro) {
            throw $erro;
        }
    }

    public function buscarTodos($conn) {
        try {
            $sql = "SELECT * FROM Contatos";
            $stmt = $conn->prepare($sql);
            $stmt->execute();
            $resultado = $stmt->fetchAll(PDO::FETCH_OBJ);
            $listaContatos = [];
            
            foreach($resultado as $contatoPDO) {
                $contato = new Contato();
                $contato->contatoPDOParaContato($contatoPDO);
                $listaContatos[] = $contato;
            }            
            return $listaContatos;
        } catch(Exception $erro) {
            throw $erro;
        }
    }
    public function editarContato($contato, $conn) {
        try {
            $sql = "UPDATE Contatos SET nome = ?, telefone = ? WHERE id = ?";
            $stmt = $conn->prepare($sql);
            $stmt->bindValue(1, $contato->getNome());
            $stmt->bindValue(2, $contato->getTelefone());
            $stmt->bindValue(3, $contato->getId());
            $stmt->execute();
            return $contato;
        } catch(Exception $erro) {
            throw $erro;
        }
    }
    public function excluirContato($id, $conn) {
        try {
            $sql = "DELETE FROM Contatos WHERE id = ?";
            $stmt = $conn->prepare($sql);
            $stmt->bindValue(1, $id);
            $stmt->execute();
            return true;
        } catch(Exception $erro) {
            throw $erro;
        }
    }
}
?>