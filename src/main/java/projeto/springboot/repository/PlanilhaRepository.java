/**
 * 
 */
package projeto.springboot.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import projeto.springboot.constante.ColunaEnum;
import projeto.springboot.constante.MensagemEnum;
import projeto.springboot.exception.MessageException;
import projeto.springboot.model.Coluna;
import projeto.springboot.model.LinhaExcel;
import projeto.springboot.model.PlanilhaExcel;

/**
 * @author resource
 *
 */
@Repository
public class PlanilhaRepository {
	
	
	private static final Logger log = LogManager.getLogger(PlanilhaRepository.class);
	
	// Aqui precisa colocar o diretorio que vai ficar a planilha, se não ele não vai achar
	public File file = new File("C:\\tmp\\documento.xlsx");
	
	
	/**
	 * Consultar Planilha excell
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<PlanilhaExcel> consultarPlanilhaExcel() throws Exception {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			int linha = 0;
			List<PlanilhaExcel> listaPlanilha = new ArrayList<PlanilhaExcel>();
			List<Coluna> listaColuna = new ArrayList<Coluna>();

			while (rowIterator.hasNext()) {
				PlanilhaExcel planilha = new PlanilhaExcel();
				
				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.iterator();
				linha += 1;
				log.info(linha);
				System.out.println(linha);
				listaColuna = new ArrayList<Coluna>();
				int coluna = 1;
				while (cellIterator.hasNext()) {
					Cell celula = cellIterator.next();
					listaColuna.add(new Coluna(ColunaEnum.getCodigo(coluna), celula != null ? celula.toString() : null));
					++coluna;
					log.info(celula);
				}
				planilha.setColuna(listaColuna);
				planilha.setLinha(linha);
				listaPlanilha.add(planilha);
			}
			
			return listaPlanilha;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new MessageException(e.getMessage(),e);
		}
	}
	
	/**
	 * Alterar e remover alguma coluna da planilha
	 * 
	 * @param request
	 * @throws Exception
	 */
	public void alterarPlanilha(LinhaExcel request) throws Exception {
			try {
				FileInputStream imput = new FileInputStream(
						file);

				XSSFWorkbook workbook = new XSSFWorkbook(imput);
				XSSFSheet sheet = workbook.getSheetAt(0);

				Cell cell = null;
				Iterator<Row> rowIterator = sheet.iterator();
				int linha =0;
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.iterator();
					++linha;
					int colunaIndex = 1;
					log.info(linha);
					while (cellIterator.hasNext()) {
						cell = cellIterator.next();
						log.info(cell);
						if(linha == request.getLinha()) {
							for(Coluna coluna : request.getColuna()) {
								if(ColunaEnum.getColuna(coluna.getColuna()) == colunaIndex) {
									cell.setCellValue(coluna.getValor());
								}
							}
						}
						colunaIndex++;
					}
				}
				imput.close();

				FileOutputStream outFile = new FileOutputStream(file);
				workbook.write(outFile);
				outFile.close();
			} catch (FileNotFoundException e) {
				log.error(e.getMessage());
				throw new Exception(MensagemEnum.MENSAGEM_ERROR.getMensagem());
			} catch (IOException e) {
				log.error(e.getMessage());
				throw new MessageException(e.getMessage(),e);
			}
	}
	
}
