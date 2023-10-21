/**
 * Country class represents a country. It holds the name of the country and the name
 * of its capital. It also holds the population, GDP, GDPPC, Area, APC, and Happiness Index
 * of a given country object. 
 * @author Riley Tittle
 * @version 09/05/2023
 * */
public class Country {
	private String name;
	private String capital;
	private double population;
	private double Gdp;
	private double GdpPerCapita;
	private double areaPerCapita;
	private double area;
	private double happyIndex;
	
	/**
	 * Country is a constructor method. It sets all the information for
	 * a country object when it is created.
	 * @param name a string that is the name of the Country
	 * @param capital a string that is the name of the Capital
	 * @param population a double that is the population of the Country
	 * @param Gdp a double that is the GDP of the Country
	 * @param area a double that is the area of the Country
	 * @param happyIndex a double that is the Happiness Index of the Country
	 */
	public Country(String name, String capital, double population, 
			double Gdp, double area, double happyIndex)
	{
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.Gdp = Gdp;
		this.GdpPerCapita = Gdp / population;
		this.area = area;
		this.areaPerCapita = area / population;
		this.happyIndex = happyIndex;
	}//end Country constructor
	
	/**
	 * setName sets the name field in the Country object. It takes
	 * a string as a parameter, which is used as the name. 
	 * @param name the name to be assigned to the Country object.
	 */
	public void setName(String name)
	{
		this.name = name;
	}//end setName method
	
	/**
	 * getName returns the name of the Country object. 
	 * @return the name of the Country object. 
	 */
	public String getName()
	{
		return this.name;
	}//end getName method
	
	/**
	 * setCaptial sets the name of the Capital in the Country object. 
	 * It takes a string as a parameter, which is used as the Capital.
	 * @param capital the Capital of the Country object. 
	 */
	public void setCapital(String capital)
	{
		this.capital = capital;
	}//end setCapital method
	
	/**
	 * getCapital returns a string of the name of the Capital of the Country object.
	 * @return a string that is the name of the Capital.
	 */
	public String getCapital()
	{
		return this.capital;
	}//end getCapital method
	
	/**
	 * setPopulation sets the population of the country object with the double parameter.
	 * @param population a double variable storing the population of the Country
	 */
	public void setPopulation(double population)
	{
		this.population = population;
	}//end setPopulation method
	
	/**
	 * getPopulation returns the population of the country as a double
	 * @return
	 */
	public double getPopulation()
	{
		return this.population;
	}//end getPopulation method
	
	/**
	 * setGdp sets the GDP of the country object with the double parameter.
	 * @param Gdp the GDP of the country object as a double
	 */
	public void setGdp(double Gdp)
	{
		this.Gdp = Gdp;
	}//end setGdp method
	
	/**
	 * getGdp returns the GDP of the Country object as a double
	 * @return the GDP of the Country as a double
	 */
	public double getGdp()
	{
		return this.Gdp;
	}
	/**
	 * setArea sets the Area of a Country with double parameter.
	 * @param area the area of the Country as a double
	 */
	public void setArea(double area)
	{
		this.area = area;
	}
    /**
     * getArea returns the area of the country as a double
     * @return the area of the country as a double
     */
	public double getArea()
	{
		return this.area;
	}
	/**
	 * setHappyIndex sets the Happiness Index for the Country object with the double parameter.
	 * @param happyIndex the Happiness Index of the country as a double. 
	 */
	public void setHappyIndex(double happyIndex)
	{
		this.happyIndex = happyIndex;
	}
	/**
	 * getHappyIndex returns the Happiness Index of the Country as a double.
	 * @return the Happiness Index of the Country as a double
	 */
	public double getHappyIndex()
	{
		return this.happyIndex;
	}
	/**
	 * getGdpPerCapita returns the GDP Per Capita of the Country as a double
	 * @return the GDP Per Capita of the Country as a double
	 */
	public double getGdpPerCapita()
	{
		return this.GdpPerCapita;
	}
	/**
	 * setGdpPerCapita sets the GDP Per Capita of the Country as the double parameter.
	 * @param GdpPerCapita the GDP Per Capita of the country as a double
	 */
	public void setGdpPerCapita(double GdpPerCapita)
	{
		this.GdpPerCapita = GdpPerCapita;
	}
	/**
	 * getAreaPerCapita returns the Area Per Capita of the Country as a double
	 * @return the Area Per Capita of the Country as a double
	 */
	public double getAreaPerCapita()
	{
		return this.areaPerCapita;
	}
	/**
	 * setAreaPerCapita sets the Area Per Capita of the Country as the double parameter.
	 * @param areaPerCapita the Area Per Capita of the Country as a double
	 */
	public void setAreaPerCapita(double areaPerCapita)
	{
		this.areaPerCapita = areaPerCapita;
	}
	/**
	 * print can be used on an instance of the Country class to print out the Country's 
	 * name, capital, GDP per capita, area per capita, and happiness index in an orderly fashion. 
	 */
	public void print()
	{
		//System.out.println(this.name + "\t" + this.capital + "\t" + this.Gdp + "\t" + this.area + "\t" + this.happyIndex);
		//String test = "Cole";
		//String tset = "Tittle";
		//System.out.printf("%s%s", test, tset);
		System.out.printf("%-38s%-18s%-18.3f%-18.6f%-18.3f", name, capital, GdpPerCapita, areaPerCapita, happyIndex);
		System.out.println();
	}//end print method
}//end Country class