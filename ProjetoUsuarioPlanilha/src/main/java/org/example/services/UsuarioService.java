package org.example.services;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.models.Usuario;
import org.example.repositories.EnderecoRepository;
import org.example.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import org.example.models.Endereco;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Usuario save(Usuario usuario) {return usuarioRepository.save(usuario);}
    public List<Usuario> findAll() {return usuarioRepository.findAll();}

    public Usuario findById(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chave de identificação não encontrada"));
    }

    // Adicione esta importação lá no topo do arquivo:
    // import org.apache.poi.ss.usermodel.DataFormatter;

    public void importarUsuariosViaPlanilha(MultipartFile file) {
        try {
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            List<Usuario> usuariosLidos = new ArrayList<>();

            // Instanciamos o tradutor mágico do Apache POI
            DataFormatter formatter = new DataFormatter();

            // ... (código anterior: criação do workbook, sheet, formatter, etc) ...

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row linha = sheet.getRow(i);

                if (linha == null) continue;

                // 1. Cria o Usuário vazio
                Usuario novoUsuario = new Usuario();

                // 2. Preenche os dados diretos do Usuário (Nome e Telefone)
                if (linha.getCell(1) != null) novoUsuario.setNome(formatter.formatCellValue(linha.getCell(0)));
                if (linha.getCell(2) != null) novoUsuario.setTelefone(formatter.formatCellValue(linha.getCell(1)));

                // 3. Cria o Endereço vazio
                Endereco endereco = new Endereco();

                // 4. Preenche os dados do Endereço
                if (linha.getCell(2) != null) endereco.setLogradouro(formatter.formatCellValue(linha.getCell(2)));
                if (linha.getCell(3) != null) endereco.setNumero(formatter.formatCellValue(linha.getCell(3)));
                if (linha.getCell(4) != null) endereco.setCep(formatter.formatCellValue(linha.getCell(4)));
                if (linha.getCell(5) != null) endereco.setBairro(formatter.formatCellValue(linha.getCell(5)));
                if (linha.getCell(6) != null) endereco.setCidade(formatter.formatCellValue(linha.getCell(6)));

                // 5. O Pulo do Gato: Guarda o Endereço preenchido dentro do Usuário!
                // (Verifique se o nome do seu setter no Usuario é setEndereco mesmo)
                novoUsuario.setEndereco(endereco);

                // 6. Adiciona na lista para salvar no banco depois
                usuariosLidos.add(novoUsuario);
            }

            // ... (restante do código: workbook.close() e saveAll) ...

            workbook.close();
            usuarioRepository.saveAll(usuariosLidos);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
