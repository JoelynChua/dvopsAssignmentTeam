<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Listing</title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" align="center" width="760">
		<tr>
			<td>
			
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" align="left"
							style="padding-left: 0px; padding-right: 0px; padding-top: 0px; padding-bottom: 0px; font: 24px/30px Georgia; width: 228px; color: #768e4e; height: 37px">New Listing</td>
					</tr>
				</table>

			</td>
		</tr>
		<tr>
			<td>
				<form action="CreateListingServlet" method="post">
					<table border="0" cellpadding="0" cellspacing="5">

						<tr>
							<td align="center">
		
									<table border="0" cellpadding="3" cellspacing="0">
										<tr>
											<td align="right"><font
												style="font-size: 15px; font-family: Arial, Times, serif; font-weight: bold">Listing name:</font></td>
											<td><input type="text" name="listingName" maxlength="50" size="50">
											</td>
										</tr>

										<tr>
											<td align="right"><font
												style="font-size: 15px; font-family: Arial, Times, serif; font-weight: bold">Listing price:</font></td>
											<td><input type="text" name="listingPrice" maxlength="7" size="50">
											</td>
										</tr>

										<tr>
											<td align="right"><font
												style="font-size: 15px; font-family: Arial, Times, serif; font-weight: bold">Listing's country of origin:</font>
											</td>
											<td><input type="text" name="listingCountry" size="50"></td>
										</tr>
										
										<tr>
											<td align="right"><font
												style="font-size: 15px; font-family: Arial, Times, serif; font-weight: bold">Remarks:</font>
											</td>
											<td><textarea name="listingRemarks" cols="48" rows="5"></textarea></td>
										</tr>
										
										<tr>
											<td align="right"><font style="font-size: 15px; font-family: Arial, Times, serif; font-weight: bold">Listing image:</font>
											</td>
											<td>
											<textarea name="listingImage" cols="48" rows="2"></textarea>
											</td>
											
										</tr>
										
										<tr>
											<td align="right"><font
												style="font-size: 15px; font-family: Arial, Times, serif; font-weight: bold">user ID:</font>
											</td>
											<td><input type="text" name="userId" size="50"></td>
										</tr>
										
									</table>
							
							</td>
						</tr>

						<tr>
							<td align="right"><br/> 
							<input type="submit" value="Create" /></td>
						</tr>

					</table>
				</form>
				
			</td>
		</tr>
	</table>


</body>
</html>